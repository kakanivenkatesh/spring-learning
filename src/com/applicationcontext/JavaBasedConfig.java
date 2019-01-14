package com.applicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedConfig {
	@Bean
	public SMSService smsservice(){
		return new SMSService();
	}

}
