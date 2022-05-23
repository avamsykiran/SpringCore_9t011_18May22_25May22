package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CounterImpl implements Counter{

	@Value("${counter.init.value}")
	private int count;
	
	@Override
	public int next() {
		return ++count;
	}

}
