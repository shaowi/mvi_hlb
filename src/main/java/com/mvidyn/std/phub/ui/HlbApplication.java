package com.mvidyn.std.phub.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.mvidyn.std.phub.ui" })
public class HlbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlbApplication.class, args);
	}

}
