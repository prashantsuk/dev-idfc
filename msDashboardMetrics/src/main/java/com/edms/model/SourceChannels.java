package com.edms.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test", set = "edp_sourcechannels")
public class SourceChannels {
	
	@AerospikeKey
	@AerospikeBin(name ="SOURCEID")
	private Integer sourceId;
	@AerospikeBin(name ="CATEGORY")
	private String category;
	@AerospikeBin(name ="SOURCENAME")
	private String sourceName;
	@AerospikeBin(name ="CREATEDBY")
	private String createdBy;
	@AerospikeBin(name ="CREATEDDATE")
	private String createdDate;
	@AerospikeBin(name ="UPDATEDBY")
	private String updatedBy;
	@AerospikeBin(name ="UPDATEDDATE")
	private String updatedDate;
	
}
