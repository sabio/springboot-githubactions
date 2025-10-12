package com.springboot_githubactions.springboot_githubactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringbootGithubactionsApplicationTests {

	@Test
	void contextLoads() {
	}

}
