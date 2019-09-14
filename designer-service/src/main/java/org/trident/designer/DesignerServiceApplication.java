package org.trident.designer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DesignerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignerServiceApplication.class, args);
	}

}
