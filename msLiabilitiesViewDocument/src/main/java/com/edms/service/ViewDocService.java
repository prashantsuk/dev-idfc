package com.edms.service;

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

public interface ViewDocService {
	
	public Response viewDoc(String docIndx,String tableType) throws UserException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException;

}
