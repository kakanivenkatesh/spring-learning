package com.applicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JavaBasedConfig {
	
	@Bean
	public SMSService smsservice(){
		return new SMSService();
	}

}
