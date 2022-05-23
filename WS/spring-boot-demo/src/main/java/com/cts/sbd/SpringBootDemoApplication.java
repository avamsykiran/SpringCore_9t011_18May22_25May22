package com.cts.sbd;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cts.sbd.ui.HomeScreen;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		//ApplicationContext is not created here yet....
		
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		//ApplicationContext is closed even before this line....
	}

	@Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
	
	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		HomeScreen screen = (HomeScreen)context.getBean("homeScreen");
		screen.run();
	}

}
