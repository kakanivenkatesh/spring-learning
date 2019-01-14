package com.injector;

import com.consumer.Consumer;
import com.consumer.MyDIApplication;
import com.services.impl.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}
