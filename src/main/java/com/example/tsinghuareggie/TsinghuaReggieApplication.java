package com.example.tsinghuareggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class TsinghuaReggieApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsinghuaReggieApplication.class, args);
		log.info("O.o Project Star Ok! o.O");
	}

}
