package com.example.obrestordenadores;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObRestOrdenadoresApplicationTests {

	@Test
	void contextLoads() {
		// Ver info del sistema.
		System.getenv().forEach(
				(key, value)-> System.out.println(key + " " + value)
		);
	}

}
