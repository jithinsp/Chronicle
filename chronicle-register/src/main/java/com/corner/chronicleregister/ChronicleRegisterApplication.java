package com.corner.chronicleregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChronicleRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChronicleRegisterApplication.class, args);
	}

}
