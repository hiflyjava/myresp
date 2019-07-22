package com.pg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@MapperScan("com.pg.mapper")
@EnableCaching

public class NewAttenceSysApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NewAttenceSysApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NewAttenceSysApplication.class);
	}

}
