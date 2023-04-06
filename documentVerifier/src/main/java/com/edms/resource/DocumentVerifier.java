package com.edms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edms.model.DocumentResponse;
import com.edms.service.DocVerifierService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("verification/")
public class DocumentVerifier {

	@Autowired
	private DocVerifierService docVerifierService;

	@PostMapping("Validate")
	public DocumentResponse checkfiles(String filePath, String fileName, String password) throws Exception {
		return docVerifierService.docVerification(filePath, fileName, password);

	}

}
