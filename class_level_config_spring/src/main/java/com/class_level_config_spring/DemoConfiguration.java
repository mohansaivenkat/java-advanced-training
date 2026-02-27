package com.class_level_config_spring;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@Configuration
@ComponentScan(basePackages = "com" )
public class DemoConfiguration {
	
	
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public List<String> getList(){
		return List.of("Mohan MC","Puneeth","Naman Lodu");
	}
	
	@Bean
	public Map<String,Integer> getMap(){		
		return Map.of(
		        "Apple", 100,
		        "Banana", 50,
		        "Cherry", 200
		    );
	}

}
