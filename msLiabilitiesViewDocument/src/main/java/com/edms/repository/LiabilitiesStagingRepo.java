package com.edms.repository;

import java.util.List;

import com.edms.domain.LiabilitiesStaging;

public interface LiabilitiesStagingRepo {

	
	public List<LiabilitiesStaging> findAll();

	public void save(LiabilitiesStaging edpLiabilities) ;
}
