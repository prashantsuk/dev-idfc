package com.edms.repository;

import java.util.List;


import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.mapper.tools.AeroMapper;
import com.edms.model.LiabilitiesEntity;

import jakarta.inject.Inject;


public class LiabilitiesRepository{

	@Inject
	AeroMapper aeroMapper;

	Policy policy = new Policy();

	@Inject
	private AerospikeClient readClient;

	@Inject
	private AerospikeClient writeClient;
	
//	public List<LiabilitiesEntity> findBySourceId(Integer sourceId){
//			List<LiabilitiesEntity> result = new ArrayList<LiabilitiesEntity>();
//			try {
//			RecordSet records = readClient.query(queryP, statement);
//			while (records.next()) {
//				Record record = records.getRecord();
//				RecordsAssets rec = aeroMapper.getMappingConverter().convertToObject(RecordsAssets.class, record);
//				result.add(rec);
//				records.close();			
//				
//				}
//			catch(AerospikeException ae) {
//				ae.printStackTrace();
//			}
//			return result;
//		}
	
	public List<LiabilitiesEntity> findAll() {
		return  aeroMapper.scan(LiabilitiesEntity.class);
	}

	}
