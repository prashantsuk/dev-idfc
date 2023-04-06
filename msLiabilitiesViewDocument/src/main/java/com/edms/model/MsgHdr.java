package com.edms.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgHdr {
	
	@NotNull(message = "FrmObject is missing")
	private Frm frm;
	
	@NotNull(message = "HdrFldsObject is missing")
	private HdrFlds hdrFlds;
	private String rslt;
	private ErrorModel error;

}
