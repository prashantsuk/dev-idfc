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
public class DataDefCriteria {

	@NotNull(message = "indexId is mandatory")
	private String indxId;
	
	@NotNull(message = "indexType is mandatory")
	private String indxType;
	
	@NotNull(message = "indexValue is mandatory")
	private String indxVal;
}
