package com.edms.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDefCriterion {
	
	@NotNull(message = "dataDefIndex is mandatory")
	private String dataDefIndx;
	
	@NotNull(message = "dataDefName is mandatory")
	private String dataDefNm;
	
	@NotNull(message = "dataDefCriteria is missing")
	private ArrayList <DataDefCriteria> dataDefCriteria;

}
