package com.cts.scd.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceSimpleImpl implements WelcomeService {

	@Override
	public String greetUser(String userName) {
		return String.format("Hello %s!", userName);
	}

}
