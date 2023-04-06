package com.edms.controller;

import java.util.List;

import com.edms.model.MetricsResponse;
import com.edms.service.MetricsService;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Secured(SecurityRule.IS_AUTHENTICATED)
public class MetricsController {

	@Inject
	MetricsService metricsService;
	
	@Get("/getLiabilitiesMetrics")
	public List<MetricsResponse> getLiabilitiesDashboardDetails() throws Exception {
		List<MetricsResponse> result = metricsService.getLiabilitiesMetricsData();
		log.info(result.toString());
		return result;
		
	}
	
	@Get("/getAssetsMetrics")
	public List<MetricsResponse> getAssetsDashboardDetails() throws Exception {
		List<MetricsResponse> result = metricsService.getAssetsMetricsData();
		log.info(result.toString());
		return result;
	}
}
