package com.pulsesg.platform.core.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * @author Vijayasai Kesanupalli
 */
@SpringBootApplication
@RefreshScope
public class PulsesgTaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulsesgTaskServiceApplication.class, args);
	}

}
