package com.cts.scd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.scd.service.Counter;
import com.cts.scd.service.WelcomeService;

@Component
public class HomeScreen {

	@Autowired
	@Qualifier("welcomeServiceSimpleImpl")
	private WelcomeService welcomeService1;

	@Autowired
	@Qualifier("welcomeServiceParamedImpl")
	private WelcomeService welcomeService2;
	
	@Autowired
	private Counter counter1;

	@Autowired
	private Counter counter2;

	@Autowired
	private Counter counter3;
	
	@Autowired
	private Scanner scanner;

	public void run() {
		System.out.println("Spring Core Demo Application");
		System.out.println("--------------------------------------------------");

		System.out.println("Enter your name: ");
		String userName = scanner.next();
		System.out.println(welcomeService1.greetUser(userName));
		System.out.println(welcomeService2.greetUser(userName));
		
		System.out.println(counter1.next());
		System.out.println(counter2.next());
		System.out.println(counter3.next());
	}
}
