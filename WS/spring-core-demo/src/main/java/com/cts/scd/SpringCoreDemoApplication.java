package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.ui.HomeScreen;

public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringCoreDemoApplicationConfig.class);
		
		HomeScreen screen = (HomeScreen) context.getBean("homeScreen");
		screen.run();
	}

}
