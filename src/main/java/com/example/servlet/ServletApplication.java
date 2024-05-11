package com.example.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan	// 스프링이 자동으로 현재 내 패키지를 포함한 하위 패키지를 다 확인해서 Servlet을 다 찾아서 자동으로 Servlet을 등록해서 실행할 수 있게함
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
