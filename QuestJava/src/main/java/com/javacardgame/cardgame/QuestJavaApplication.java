package com.javacardgame.cardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class QuestJavaApplication {
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(QuestJavaApplication.class, args);
	}
}