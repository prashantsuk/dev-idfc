package com.edms.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AerospikeRecord(namespace = "test", set = "edp_assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetsEntity {
	
	@AerospikeKey
	@AerospikeBin(name ="PK")
	private Long pk;


	@AerospikeBin(name ="EDPID")
	private String edpId;
	
	@AerospikeBin(name ="SOURCEID")
	private Integer sourceId;
	@AerospikeBin(name ="SOURCENAME")
	private String sourceName;
	
	
}
