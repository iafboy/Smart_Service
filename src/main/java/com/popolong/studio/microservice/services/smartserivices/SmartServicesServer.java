package com.popolong.studio.microservice.services.smartserivices;

import java.util.logging.Logger;

import com.popolong.studio.microservice.common.CommonParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = CommonParams.BASEACCOUNTPATH)
public class SmartServicesServer {
	protected static Logger logger = Logger.getLogger(SmartServicesServer.class.getName());
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "microservice-server");
		System.setProperty("javax.net.ssl.trustStore", CommonParams.InternalCertPath);
		SpringApplication.run(SmartServicesServer.class, args);
	
	}
	
}
