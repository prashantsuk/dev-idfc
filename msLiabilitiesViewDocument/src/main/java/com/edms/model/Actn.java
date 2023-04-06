package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actn {

	 private String paradigm;
	 private String nm;
	 private String vrsn;
}
