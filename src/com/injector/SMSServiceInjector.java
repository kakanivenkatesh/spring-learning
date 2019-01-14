package com.injector;

import com.consumer.Consumer;
import com.consumer.MyDIApplication;
import com.services.impl.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}