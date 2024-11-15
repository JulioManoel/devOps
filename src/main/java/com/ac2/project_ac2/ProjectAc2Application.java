package com.ac2.project_ac2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ProjectAc2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAc2Application.class, args);
	}
	
	@RequestMapping("/")
	@ResponseBody
	String home()
	{
		return "Hello World";
	}

}
