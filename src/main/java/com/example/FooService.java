package com.example;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FooService {

	@Cacheable("foo")
	public Optional<String> computeFoo(String bar) {
		System.out.println("computing --> " + bar);
		return (bar != null ? Optional.of(bar) : Optional.empty());
	}

}
