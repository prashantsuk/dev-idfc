package com.edms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetricsResponse {

	private Integer sourceId;
	private String sourceName;
	private Float percentage;
	private Integer numberOfRecords;
	private String exception;
	private String error;

}
