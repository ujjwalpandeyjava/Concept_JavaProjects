package com.ConceptsSpringBoot.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String home() {
		return "Home";
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "OK";
	}

	@GetMapping("/time")
	public Map<String, String> serverTime() {
		return Map.of("serverTime", java.time.ZonedDateTime.now().toString());
	}
}
