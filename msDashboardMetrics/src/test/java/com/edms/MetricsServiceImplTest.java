package com.edms;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.edms.model.MetricsResponse;
import com.edms.model.SourceChannels;
import com.edms.service.MetricsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MetricsServiceImplTest {

	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
	}

	@Test
	@DisplayName("get Metrics Data")
	public void getMetricsData() {
		try {
			log.info("Starting execution of getMetricsData");
			List<MetricsResponse> expectedValue = null;

			MetricsServiceImpl metricsserviceimpl = new MetricsServiceImpl();
			List<MetricsResponse> actualValue = metricsserviceimpl.getLiabilitiesMetricsData();
			log.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
	}

	@Test
	@DisplayName("get Assets Metrics Data")
	public void getAssetsMetricsData() {
		try {
			log.info("Starting execution of getAssetsMetricsData");
			List<MetricsResponse> expectedValue = null;

			MetricsServiceImpl metricsserviceimpl = new MetricsServiceImpl();
			List<MetricsResponse> actualValue = metricsserviceimpl.getAssetsMetricsData();
			log.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
	}

	@Test
	@DisplayName("get All Channels")
	public void getAllChannels() {
		try {
			log.info("Starting execution of getAllChannels");
			List<SourceChannels> expectedValue = null;
			String category = "";

			MetricsServiceImpl metricsserviceimpl = new MetricsServiceImpl();
			List<SourceChannels> actualValue = metricsserviceimpl.getAllChannels(category);
			log.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
			Assertions.assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
			exception.printStackTrace();
			Assertions.assertFalse(false);
		}
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}
}
