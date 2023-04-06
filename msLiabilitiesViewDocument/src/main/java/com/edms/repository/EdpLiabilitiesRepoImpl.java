package com.edms.repository;

import java.util.List;

import com.aerospike.mapper.tools.AeroMapper;
import com.edms.domain.EdpLiabilities;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class EdpLiabilitiesRepoImpl implements EdpLiabilitiesRepo{
	
	@Inject
	AeroMapper aeroMapper;
	
	
	public List<EdpLiabilities> findAll()
	{
		return aeroMapper.scan(EdpLiabilities.class);
	}

	public void save(EdpLiabilities edpLiabilities) {
		aeroMapper.save(edpLiabilities);
		
	}

}
