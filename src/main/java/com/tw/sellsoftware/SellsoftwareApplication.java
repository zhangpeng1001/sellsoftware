package com.tw.sellsoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tw.sellsoftware.*.mapper")
public class SellsoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellsoftwareApplication.class, args);
	}

}
