package com.edms.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import com.edms.exception.DocumentFoundException;
import com.edms.model.DocumentResponse;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

@Service
public class DocVerifierService {

	public DocumentResponse docVerification(String filePath, String fileName, String password) throws Exception {
		DocumentResponse documentVerificationRes = new DocumentResponse();

		final File file = new File(filePath + fileName);
		boolean check = file.exists();
		if (!check)
			throw new DocumentFoundException("File not Found");

		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor(file.getName());

		if ("application/pdf".equalsIgnoreCase(mimeType)) {

			InputStream fis = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
			try {
				PDDocument doc = PDDocument.load(fis, password);
				documentVerificationRes.setValidDocument(true);
				doc.close();
			} catch (InvalidPasswordException e) {
				documentVerificationRes.setValidDocument(false);
				documentVerificationRes.setErrMessage("Password is not matched");
			}

		} else if ("application/zip".equalsIgnoreCase(mimeType)) {

			try {
				ZipFile zipFile = new ZipFile(filePath + fileName, password.toCharArray());
				zipFile.extractAll(filePath);
				documentVerificationRes.setValidDocument(true);
				zipFile.close();
				if (zipFile.isEncrypted()) {
					zipFile.setPassword(password.toCharArray());
				}
			} catch (ZipException e) {
				documentVerificationRes.setValidDocument(false);
				documentVerificationRes.setErrMessage("Password is not matched");
				e.printStackTrace();
			}

		} else if ("application/vnd.ms-excel".equalsIgnoreCase(mimeType)
				|| "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equalsIgnoreCase(mimeType)) {

			try {
				FileInputStream fileInput = new FileInputStream(filePath + fileName);
				Workbook workbook = WorkbookFactory.create(fileInput, password);
				documentVerificationRes.setValidDocument(true);
				workbook.close();

			} catch (EncryptedDocumentException ex) {
				documentVerificationRes.setValidDocument(false);
				documentVerificationRes.setErrMessage("Password is not matched");
				ex.printStackTrace();
			}
		} else if ("application/vnd.openxmlformats-officedocument.wordprocessingml.document".equalsIgnoreCase(mimeType)
				|| "application/msword".equalsIgnoreCase(mimeType)) {

			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			try (XWPFDocument document = new XWPFDocument(fis)) {

				if (document.isEnforcedProtection()) {
					documentVerificationRes.setValidDocument(document.validateProtectionPassword(password));
				}
			} catch (OLE2NotOfficeXmlFileException fe) {

				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath + fileName));
				EncryptionInfo info = new EncryptionInfo(fs);
				Decryptor doc = Decryptor.getInstance(info);
				documentVerificationRes.setValidDocument(doc.verifyPassword(password));

			} catch (Exception ex) {
				documentVerificationRes.setValidDocument(false);
				documentVerificationRes.setErrMessage("Password is not matched");
				throw new RuntimeException("Unable to process encrypted document", ex);
			}
		} else {

			documentVerificationRes.setValidDocument(true);
		}

		return documentVerificationRes;

	}

}
