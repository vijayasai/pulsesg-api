package com.data5.pulsesgapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@Slf4j
@SpringBootApplication
@EnableCircuitBreaker
public class PulsesgApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulsesgApiApplication.class, args);
	}

}
