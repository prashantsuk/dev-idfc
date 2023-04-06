package com.edms.repository;

import java.util.List;

import com.edms.domain.EdpLiabilities;

public interface EdpLiabilitiesRepo {

	public List<EdpLiabilities> findAll();

	public void save(EdpLiabilities edpLiabilities) ;
}
