package com.edms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "com.edms.*" })
@EnableEurekaClient
public class DocumentVerifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentVerifierApplication.class, args);
	}

}
