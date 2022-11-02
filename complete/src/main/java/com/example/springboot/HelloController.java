package com.example.springboot;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

	private static final TelemetryClient telemetryClient = new TelemetryClient();
	private static final AtomicInteger counter = new AtomicInteger();

	@GetMapping("/")
	public String index() {
		telemetryClient.trackMetric("mymetric", counter.incrementAndGet());
		return "Greetings from Spring Boot!";
	}

}
