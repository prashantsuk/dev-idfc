package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private MsgHdr msgHdr;
	private MsgBdy msgBdy;

}
