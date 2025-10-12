package com.springboot_githubactions.springboot_githubactions;

import org.springframework.boot.SpringApplication;

public class TestSpringbootGithubactionsApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootGithubactionsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
