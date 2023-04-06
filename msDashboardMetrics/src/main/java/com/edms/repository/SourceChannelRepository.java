package com.edms.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edms.model.SourceChannels;

import jakarta.inject.Inject;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.mapper.tools.AeroMapper;

public class SourceChannelRepository {
	@Inject
	AeroMapper aeroMapper;

	Policy policy = new Policy();

	@Inject
	private AerospikeClient readClient;

	@Inject
	private AerospikeClient writeClient;

	public List<SourceChannels> findByCategory(String category) throws Exception {
		List<SourceChannels> result = new ArrayList<SourceChannels>();
//			RecordSet records = readClient.query(queryP, statement);
//			while (records.next()) {
//				Record record = records.getRecord();
//				RecordsAssets rec = aeroMapper.getMappingConverter().convertToObject(RecordsAssets.class, record);
//				docs.add(rec);
//				records.close();			
		result = aeroMapper.scan(SourceChannels.class);
		result = result.stream().filter(e -> e.getCategory().contentEquals(category)).collect(Collectors.toList());
		return result;
	}
}
