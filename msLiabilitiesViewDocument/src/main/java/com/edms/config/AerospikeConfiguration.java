package com.edms.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class AerospikeConfiguration {

    /**
     * Aerospike client aerospike client.
     *
     * @param aerospikeProperties the aerospike properties
     * @return the aerospike client
     */
    @Singleton
    public AerospikeClient aerospikeClient(AerospikeConfigurationProperties aerospikeProperties) {
      
        return new AerospikeClient(aerospikeProperties.getHost(), aerospikeProperties.getPort());
    }

    /**
     * Aerospike mapper aero mapper.
     *
     * @param aerospikeClient the aerospike client
     * @return the aero mapper
     */
    @Singleton
    public AeroMapper aerospikeMapper(AerospikeClient aerospikeClient) {
        return new AeroMapper.Builder(aerospikeClient).build();
    }

    /*    *//**
     * Nio event loops event loops.
     *
     * @return the event loops
     */

}