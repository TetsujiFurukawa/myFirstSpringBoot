package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("MFamilyMapper") // スキャンするベースパッケージを明示的に指定する
@SpringBootApplication
public class MyBatisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisTestApplication.class, args);
	}
}
