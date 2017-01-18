package com.example;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class TestCacheOptionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCacheOptionalApplication.class, args);
	}


	@Bean
	public ApplicationRunner runner(FooService fooService) {
		return args -> {
			System.out.println("Computing test 3 times...");
			Optional<String> test = fooService.computeFoo("test");
			Optional<String> test2 = fooService.computeFoo("test");
			Optional<String> test3 = fooService.computeFoo("test");
			System.out.println("Got " + Arrays.asList(test, test2, test3));

			System.out.println("Computing null 3 times...");
			Optional<String> empty = fooService.computeFoo("null");
			Optional<String> empty2 = fooService.computeFoo("null");
			Optional<String> empty3 = fooService.computeFoo("null");
			System.out.println("Got " + Arrays.asList(empty, empty2, empty3));
		};
	}

}
