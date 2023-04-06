package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Srvc {

	 private String nm;
	 private String cntxt;
	 private Actn actnObject;
}
