package com.revacomm.Project1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class Project1ApplicationTests {
	@Autowired
	private PersonController personController;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAll() throws Exception {
		System.out.println("========== testGetAll() ==========");
		ArrayList<Person> result = (ArrayList<Person>) personController.getAllEmployees();
		System.out.println(result);
		System.out.println(result.getClass());
		System.out.println(result.size());
	}

	// Test Model
	@Test
	void testPersonModel() throws Exception {
		Person johnLennon = new Person("John","Lennon",27);
	}

	// Test Controller
	@Test
	void testPersonController() throws Exception {
	}

	// Test Service
	@Test
	void testPersonService() throws Exception {
	}
}
