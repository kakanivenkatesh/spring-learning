package com.AOP.Example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectJAutoProxyConfig {
	
	@Bean	
	  public UserAspect userAspect(){
		 return new UserAspect();
	  }
	
	@Bean
	  public UserService userService(){
		 return new UserService();
	  }

}
