package com.cts.scd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.scd")
@PropertySource("classpath:application.properties")
public class SpringCoreDemoApplicationConfig {

}
