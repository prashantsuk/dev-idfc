package com.edms.service;

import jakarta.inject.Singleton;

import java.util.List;


import com.edms.model.MetricsResponse;

/**
 * @author Koistubh Kasadiwar
 *
 */
@Singleton
public interface MetricsService {
	
	public List<MetricsResponse> getAssetsMetricsData() throws Exception;
	
	public List<MetricsResponse> getLiabilitiesMetricsData() throws Exception;

}
