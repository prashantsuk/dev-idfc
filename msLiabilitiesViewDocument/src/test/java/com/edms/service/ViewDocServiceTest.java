package com.edms.service;

import static com.edms.util.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.edms.exception.UserException;
import com.edms.model.MsgBdy;
import com.edms.model.MsgHdr;
import com.edms.model.Response;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
class ViewDocServiceTest {

//	@Inject
//	CommonService commonService;
//	
//	@Inject
//	DocLiabilitiesRepo docLiabilitiesRepo;
//	
//	@Inject
//	ViewDocServiceImpl viewDocServiceImpl;
//	
//	private MsgBdy msgBdy;
//	private List<DocLiabilities> docList;
//	private DocLiabilities docLiabilities1;
//	private DocLiabilities docLiabilities2;
//	
//	
//	@BeforeEach
//	public void setUp() {
//		msgBdy=new MsgBdy();
//		msgBdy.setCustId("123456");
//		msgBdy.setDocType("Form6061");
//		msgBdy.setDocName("Voter Identity Card");
//		msgBdy.setSrcNm("SFDC");
//		
//		docList=new ArrayList<>();
//		docLiabilities1=new DocLiabilities();
//    	docLiabilities1.setCustomerId("123456");
//    	docLiabilities1.setDocTypeName("Form6061");
//    	docLiabilities1.setDocumentName("Voter Identity Card");
//    	docLiabilities1.setSourceName("SFDC");
//    	docLiabilities1.setEdmsId("EDMS1");
//    	docLiabilities1.setUploadedDate(new Date(2023, 01, 25));
//
//		docLiabilities2=new DocLiabilities();
//    	docLiabilities2.setCustomerId("123456");
//    	docLiabilities2.setDocTypeName("Form6061");
//    	docLiabilities2.setDocumentName("Voter Identity Card");
//    	docLiabilities2.setSourceName("SFDC");
//    	docLiabilities2.setEdmsId("EDMS2");
//    	docLiabilities2.setUploadedDate(new Date(2023, 01, 27));
//    	
//    	docList.add(docLiabilities1);
//    	docList.add(docLiabilities2);
//	}
//	
//	@Test
//	void ViewDocumentSuccessTest() throws UserException, IOException {
//		
//		when(docLiabilitiesRepo.findAll()).thenReturn(docList);
//		when(commonService.setMessageBody(any(), any(),any())).thenReturn(
//				MsgBdy.builder().msg(SUCCESS).sts("0").docIndx("EDMS2").build()
//		);
//		when(commonService.setMessageHeader(any())).thenReturn(
//				MsgHdr.builder().rslt(OK).build()
//		);
//		
//		Response viewDMSDocResp=Response.builder().msgHdr(MsgHdr.builder().rslt(OK).build()).msgBdy(
//				MsgBdy.builder().sts("0").docIndx("EDMS2").msg(SUCCESS).build()).build();
//		
//		Response resp=viewDocServiceImpl.viewDoc(msgBdy);
//		
//		assertEquals(viewDMSDocResp, resp);
//	}
//
//	@Test()
//	void ViewDocumentException() throws UserException, IOException {
//
//		when(docLiabilitiesRepo.findAll()).thenReturn(new ArrayList<>());
//		assertThrows(UserException.class, ()->viewDocServiceImpl.viewDoc(msgBdy));
//	
//	}
//
//	@MockBean(CommonService.class)
//	CommonService commonService() {
//        return mock(CommonService.class);
//    }
//	
//	@MockBean(DocLiabilitiesRepo.class)
//	DocLiabilitiesRepo docLiabilitiesRepo() {
//        return mock(DocLiabilitiesRepo.class);
//    }
	
}
