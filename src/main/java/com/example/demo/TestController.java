package com.example.demo;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TestController {
	public final TestRepository testRepository;
	@GetMapping("/api/v1/customers")
	public String findAllCustomers(){
		List<TestEntity> testList = testRepository.findAll();
		TestEntity testEntity = new TestEntity();
		testEntity.setName("aaaa");
		testRepository.saveAndFlush(testEntity);
		if(testList.isEmpty()) {
			TestEntity testEntity2 = new TestEntity();
			testEntity2.setName("aaaa");
			testRepository.saveAndFlush(testEntity2);
		}
		testList = testRepository.findAll();
		String result = testList.stream().map(TestEntity::toString).collect(Collectors.joining(","));
		return result;
	}
}
