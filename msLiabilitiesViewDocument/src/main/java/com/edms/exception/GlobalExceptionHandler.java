package com.edms.exception;

import static com.edms.util.Constants.*;

import com.edms.model.Actn;
import com.edms.model.ErrorModel;
import com.edms.model.MsgHdr;
import com.edms.model.Response;
import com.edms.model.Srvc;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Produces
@Singleton
@Requires(classes = {Exception.class, ExceptionHandler.class})
@Slf4j
public class GlobalExceptionHandler implements ExceptionHandler<Exception, HttpResponse>{
	
	@Override
    public HttpResponse<Response> handle(HttpRequest request, Exception exception) {
		
		log.error(EXCEPTION_OCCURED,exception);
		Actn actn=Actn.builder().nm(VIEW_DOC).paradigm(REPLY).vrsn(VERSION).build();
		Srvc srvc=Srvc.builder().actnObject(actn).cntxt(DOC_MGMT).nm(DOC_MGMT).build();
		  
		ErrorModel error=ErrorModel.builder().cd(EXP_500).rsn(exception.getMessage()).srvcObject(srvc).build();

		MsgHdr msgHdr=MsgHdr.builder().error(error).rslt(ERROR).build();
			 
		Response responseMsg=Response.builder().msgHdr(msgHdr).build();
        return HttpResponse.serverError(responseMsg); 
    }

}

