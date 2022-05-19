package com.cts.scd.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.scd.service.WelcomeService;

@Component
public class HomeScreen {

	@Autowired
	@Qualifier("welcomeServiceSimpleImpl")
	private WelcomeService welcomeService1;

	@Autowired
	@Qualifier("welcomeServiceParamedImpl")
	private WelcomeService welcomeService2;

	public void run() {
		System.out.println("Spring Core Demo Application");
		System.out.println("--------------------------------------------------");

		String userName = "Vamsy Kiran";
		System.out.println(welcomeService1.greetUser(userName));
		System.out.println(welcomeService2.greetUser(userName));
	}
}
