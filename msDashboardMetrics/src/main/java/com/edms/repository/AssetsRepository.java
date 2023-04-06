package com.edms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.policy.Policy;
import com.aerospike.mapper.tools.AeroMapper;
import com.edms.model.AssetsEntity;

import jakarta.inject.Inject;


public class AssetsRepository{
	
	@Inject
	AeroMapper aeroMapper;

	Policy policy = new Policy();

	@Inject
	private AerospikeClient readClient;

	@Inject
	private AerospikeClient writeClient;

//	public List<AssetsEntity> findBySourceId(Integer sourceId){
//		List<AssetsEntity> result = new ArrayList<AssetsEntity>();
//		try {
////		RecordSet records = readClient.query(queryP, statement);
////		while (records.next()) {
////			Record record = records.getRecord();
////			RecordsAssets rec = aeroMapper.getMappingConverter().convertToObject(RecordsAssets.class, record);
////			result.add(rec);
////			records.close();			

//			}
//		catch(AerospikeException ae) {
//			ae.printStackTrace();
//		}
//		return result;
//	}

	public List<AssetsEntity> findAll() {
		return aeroMapper.scan(AssetsEntity.class);
	}

}
