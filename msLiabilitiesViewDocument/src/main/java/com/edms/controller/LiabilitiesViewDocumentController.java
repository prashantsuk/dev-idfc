package com.edms.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import com.edms.exception.UserException;
import com.edms.model.Response;
import com.edms.service.CommonService;
import com.edms.service.ViewDocServiceImpl;
import com.itextpdf.text.DocumentException;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

@Controller("/viewDoc")
public class LiabilitiesViewDocumentController {
	
	@Inject
	ViewDocServiceImpl viewDocServiceImpl;
	
	@Inject
	CommonService commonService;
	
	@Get
	public HttpResponse<Response> liabilitiesViewDoc(@QueryValue String docIndx, @QueryValue String tableType) throws UserException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
	{
		return HttpResponse.ok(viewDocServiceImpl.viewDoc(docIndx,tableType));
	}
	
	@Get("/unprotect")
	public HttpResponse<String> liabilitiesUnprotect() throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, DocumentException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException
	{
		return HttpResponse.ok(viewDocServiceImpl.unprotect());
	}
	
}
