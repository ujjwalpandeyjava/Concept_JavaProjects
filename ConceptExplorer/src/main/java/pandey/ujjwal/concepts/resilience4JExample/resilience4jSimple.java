package pandey.ujjwal.concepts.resilience4JExample;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class resilience4jSimple {

	// Apply patterns in correct order with separate configs
	@RateLimiter(name = "rateLimiterConfig")
	@Bulkhead(name = "bulkheadConfig", type = Bulkhead.Type.SEMAPHORE)
	@TimeLimiter(name = "timeLimiterConfig")
	@Retry(name = "retryConfig")
	@CircuitBreaker(name = "circuitBreakerConfig", fallbackMethod = "fallback")
	public CompletableFuture<String> callExternalService() {
		return CompletableFuture.supplyAsync(() -> {
			simulateDelay(); // Simulate slow service
			return "Success from external service!";
		});
	}

	// Fallback for all resilience failures
	public CompletableFuture<String> fallback(Throwable ex) {
		return CompletableFuture.completedFuture("Fallback: Service unavailable");
	}

	private void simulateDelay() {
		try {
			Thread.sleep(4000); // 4 sec delay
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
