package com.cs.speedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cs.speedtest"})
public class ComCsSpeedtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComCsSpeedtestApplication.class, args);
	}

}
