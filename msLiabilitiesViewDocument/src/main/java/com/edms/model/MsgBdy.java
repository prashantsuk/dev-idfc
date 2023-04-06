package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgBdy {

	//Request
	private String dcNm;
	private String dcIndx;
	
	//Response
	private String sts;
	private String msg;
	private String bs64Doc;
	private String fileType;
	private String fileName;


}
