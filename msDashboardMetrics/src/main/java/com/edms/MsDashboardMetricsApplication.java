package com.edms;

import com.edms.util.Constants;

import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.context.ApplicationContextConfigurer;
import io.micronaut.context.annotation.ContextConfigurer;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.runtime.Micronaut;

public class MsDashboardMetricsApplication {

    public static void main(String[] args) {
        Micronaut.run(MsDashboardMetricsApplication.class, args);
    }
    
    @ContextConfigurer
    public static class DefaultEnvironmentConfigurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            String defaultEnvironment =Constants.ENV_DEV;
			builder.defaultEnvironments(defaultEnvironment );
        }
    }
}
