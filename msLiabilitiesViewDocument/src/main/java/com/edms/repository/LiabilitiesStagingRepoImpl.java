package com.edms.repository;

import java.util.List;

import com.aerospike.mapper.tools.AeroMapper;
import com.edms.domain.LiabilitiesStaging;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class LiabilitiesStagingRepoImpl implements LiabilitiesStagingRepo{
	
	@Inject
	AeroMapper aeroMapper;
	
	
	public List<LiabilitiesStaging> findAll()
	{
		return aeroMapper.scan(LiabilitiesStaging.class);
	}

	public void save(LiabilitiesStaging edpLiabilities) {
		aeroMapper.save(edpLiabilities);
		
	}

}
