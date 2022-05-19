package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceParamedImpl implements WelcomeService {

	@Value("${greet.note}")
	private String greetNote;
	
	@Override
	public String greetUser(String userName) {
		return String.format("%s %s!", greetNote,userName);
	}

}
