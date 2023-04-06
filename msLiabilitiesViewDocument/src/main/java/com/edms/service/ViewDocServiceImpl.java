package com.edms.service;

import com.edms.domain.EdpLiabilities;
import com.edms.domain.LiabilitiesStaging;
import com.edms.exception.UserException;
import com.edms.model.MsgBdy;
import com.edms.model.MsgHdr;
import com.edms.model.Response;
import com.edms.repository.EdpLiabilitiesRepoImpl;
import com.edms.repository.LiabilitiesStagingRepo;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import static com.edms.util.Constants.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.pdfbox.io.IOUtils;

@Singleton
@Slf4j
public class ViewDocServiceImpl implements ViewDocService {
	
	@Value("${fileLocation}")
	private String fileLocation;
	
	@Inject
	EdpLiabilitiesRepoImpl liabilitiesRepo;
	
	@Inject
	LiabilitiesStagingRepo liabilitiesStagingRepo;
	
	
	public Response viewDoc(String docIndx,String tableType) throws UserException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
	{
		log.info("Get document meta data started");
		
		if(tableType.equals("Main"))
		{
			log.info("Checking in main table");
			
			List<EdpLiabilities>liabilitiesList=liabilitiesRepo.findAll();
			
			if(liabilitiesList.isEmpty())
				throw new UserException("Document details not found");
			
			EdpLiabilities docLiabilities=liabilitiesList.stream().filter(f->f.getDocId().equals(docIndx)).findFirst().orElse(null);
			
			if(docLiabilities==null)
				throw new UserException("Document details not found");
			
			File file=new File(fileLocation+docLiabilities.getCustomerId()+"/"+docLiabilities.getDocumentTitle());
			
			if(!file.exists())
				throw new UserException("File not found");
				
			String base64String=encodeFileToBase64(fileLocation+docLiabilities.getCustomerId()+"/"+docLiabilities.getDocumentTitle());
			
			return buildMetaDataLiabilities(docLiabilities,base64String,null);
		}
		
		log.info("Checking in staging table");
		
		List<LiabilitiesStaging>liabilitiesList=liabilitiesStagingRepo.findAll();
		
		if(liabilitiesList.isEmpty())
			throw new UserException("Document details not found");
		
		LiabilitiesStaging docLiabilities=liabilitiesList.stream().filter(f->f.getDocId().equals(docIndx)).findFirst().orElse(null);
		
		if(docLiabilities==null)
			throw new UserException("Document details not found");
		
		File file=new File(fileLocation+docLiabilities.getCustomerId()+"/"+docLiabilities.getDocumentTitle());
		
		if(!file.exists())
			throw new UserException("File not found");
			
		String base64String=encodeFileToBase64(fileLocation+docLiabilities.getCustomerId()+"/"+docLiabilities.getDocumentTitle());
		
		return buildMetaDataLiabilities(null,base64String,docLiabilities);
		
	}
	
	
	private String encodeFileToBase64(String path) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
	    
	    log.info("Converting file to base64 string");
	    	
	    byte[] fileContent = decrypt(path);
	    return Base64.getEncoder().encodeToString(fileContent);
	   
	}
	
	private Response buildMetaDataLiabilities(EdpLiabilities entity,String base64String, LiabilitiesStaging liabilitiesStaging)
	{
		if(liabilitiesStaging==null) 
		{
			return Response.builder().msgHdr(MsgHdr.builder().rslt(OK).build()).msgBdy(MsgBdy.builder().sts("0").msg(SUCCESS)
					.bs64Doc(base64String).fileName(entity.getDocumentTitle()).fileType(entity.getFileType()).build()).build();
		}
		
		return Response.builder().msgHdr(MsgHdr.builder().rslt(OK).build()).msgBdy(MsgBdy.builder().sts("0").msg(SUCCESS)
				.bs64Doc(base64String).fileName(liabilitiesStaging.getDocumentTitle()).fileType(liabilitiesStaging.getFileType()).build()).build();
	}
	
	
	private static String key="THIS_IS_MY_SECRET_KEY_FOR_FILE_ENCRYPTION_DECRYPTION";
    
    public static SecretKey generateSecretKey(String password, byte [] iv) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), iv, 65536, 128); // AES-128
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] key = secretKeyFactory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(key, "AES");
    }
    
    
    private byte[] decrypt(String path) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
    {
    	try (FileInputStream fis = new FileInputStream(path)) {
			ByteBuffer byteBuffer = ByteBuffer.wrap(fis.readAllBytes());

			  int noonceSize = byteBuffer.getInt();

			  //Make sure that the file was encrypted properly
			  if(noonceSize < 12 || noonceSize >= 16) {
			      throw new IllegalArgumentException("Nonce size is incorrect. Make sure that the incoming data is an AES encrypted file.");
			  }
			  byte[] iv = new byte[noonceSize];
			  byteBuffer.get(iv);

			  //Prepare your key/password
			  SecretKey secretKey = generateSecretKey(key, iv);

			  //get the rest of encrypted data
			  byte[] cipherBytes = new byte[byteBuffer.remaining()];
			  byteBuffer.get(cipherBytes);

			  Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			  GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);

			  //Encryption mode on!
			  cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

			  //Encrypt the data
			  byte[] data= cipher.doFinal(cipherBytes);
			  
			  return data;
		}
    }
    
    
    public String unprotect() throws IOException, DocumentException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
    {
    	 String filePath = "C:/Users/UNIFY/Desktop/docUpload/12345678229/Vamsi_Aadhaar_1_protected_Liabilities_EDP_V1.pdf";
    	 String password = "12345";

    	 PdfReader reader = new PdfReader(decrypt(filePath, "r)OCSperbjv!zlwj"), password.getBytes());

         // Step 2: Create a ByteArrayOutputStream to hold the decrypted data
         ByteArrayOutputStream baos = new ByteArrayOutputStream();

         // Step 3: Decrypt the PDF file and write the decrypted data to the ByteArrayOutputStream
         PdfStamper stamper = new PdfStamper(reader, baos);
         stamper.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, false);
         stamper.close();

         // Step 4: Convert the decrypted data to Base64
         byte[] decryptedData = baos.toByteArray();
         String base64Data = Base64.getEncoder().encodeToString(decryptedData);

         return base64Data;
    	  
    }
    
    
    
    private byte[] decrypt(String path, String key) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
    {
    	try (FileInputStream fis = new FileInputStream(path)) {
			ByteBuffer byteBuffer = ByteBuffer.wrap(IOUtils.toByteArray(fis));

			  int noonceSize = byteBuffer.getInt();

			  //Make sure that the file was encrypted properly
			  if(noonceSize < 12 || noonceSize >= 16) {
			      throw new IllegalArgumentException("Nonce size is incorrect. Make sure that the incoming data is an AES encrypted file.");
			  }
			  byte[] iv = new byte[noonceSize];
			  byteBuffer.get(iv);

			  //Prepare your key/password
			  SecretKey secretKey = generateSecretKey(key, iv);

			  //get the rest of encrypted data
			  byte[] cipherBytes = new byte[byteBuffer.remaining()];
			  byteBuffer.get(cipherBytes);

			  Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			  GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);

			  //Encryption mode on!
			  cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

			  //Encrypt the data
			  return cipher.doFinal(cipherBytes);
		}
    }
    
}