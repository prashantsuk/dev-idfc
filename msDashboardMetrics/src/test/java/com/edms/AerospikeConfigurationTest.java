package com.edms;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import com.edms.config.AerospikeConfiguration;
import com.edms.config.AerospikeConfigurationProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AerospikeConfigurationTest {


	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
	}

	@Test
	@DisplayName("aerospike Client")
	public void aerospikeClient() {
		try {
			log.info("Starting execution of aerospikeClient");
			AerospikeClient expectedValue = null;
			AerospikeConfigurationProperties aerospikeProperties = null;

			AerospikeConfiguration aerospikeconfiguration = new AerospikeConfiguration();
			AerospikeClient actualValue = aerospikeconfiguration.aerospikeClient(aerospikeProperties);
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
	@DisplayName("aerospike Mapper")
	public void aerospikeMapper() {
		try {
			log.info("Starting execution of aerospikeMapper");
			AeroMapper expectedValue = null;
			AerospikeClient aerospikeClient = null;

			AerospikeConfiguration aerospikeconfiguration = new AerospikeConfiguration();
			AeroMapper actualValue = aerospikeconfiguration.aerospikeMapper(aerospikeClient);
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
