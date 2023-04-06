package com.edms.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import com.edms.domain.EdpLiabilities;
import com.edms.domain.LiabilitiesStaging;
import com.edms.model.MsgBdy;
import com.edms.model.MsgHdr;
import com.edms.model.Response;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import static com.edms.util.Constants.*;

@Singleton
@Slf4j
public class CommonService {
	
	@Value("${fileLocation}")
	private String fileLocation;

	public MsgBdy setMessageBody(String msg,String sts,String docIndx) {
		
		return MsgBdy.builder().msg(msg).sts(sts).dcIndx(docIndx).build();
	}
	
	
	public MsgHdr setMessageHeader(String rslt) {
		
		return MsgHdr.builder().rslt(rslt).build();
	}
	
	public String encodeFileToBase64(File file) throws IOException {
	    
	    log.info("Converting file to base64 string");
	    	
	    byte[] fileContent = Files.readAllBytes(file.toPath());
	    return Base64.getEncoder().encodeToString(fileContent);
	   
	}
	
	public Response buildMetaDataLiabilities(EdpLiabilities entity,String base64String, LiabilitiesStaging liabilitiesStaging)
	{
		if(liabilitiesStaging==null) 
		{
			return Response.builder().msgHdr(MsgHdr.builder().rslt(OK).build()).msgBdy(MsgBdy.builder().sts("0").msg(SUCCESS)
					.bs64Doc(base64String).fileName(entity.getDocumentTitle()).fileType(entity.getFileType()).build()).build();
		}
		
		return Response.builder().msgHdr(MsgHdr.builder().rslt(OK).build()).msgBdy(MsgBdy.builder().sts("0").msg(SUCCESS)
				.bs64Doc(base64String).fileName(liabilitiesStaging.getDocumentTitle()).fileType(liabilitiesStaging.getFileType()).build()).build();
	}
	
}
