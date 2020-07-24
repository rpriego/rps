package com.ciklum.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class RpsApplicationTest {

	@Autowired
	private Random random;

	@Test
	void contextLoads() {
		assertThat(random, notNullValue());
	}

}
