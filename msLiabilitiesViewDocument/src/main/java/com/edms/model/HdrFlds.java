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
public class HdrFlds {

	@NotNull(message = "cnvId is mandatory")
	private String cnvId;
	
	@NotNull(message = "msgId is mandatory")
	private String msgId;
	
	@NotNull(message = "timestamp is mandatory")
	private String timestamp;
}
