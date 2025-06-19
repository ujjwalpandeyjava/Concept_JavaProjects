package pandey.ujjwal.concepts.resilience4JExample;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4JConfig {

    // 1. 🚦 Rate Limiter: 100 requests per second
    @Bean
    public RateLimiter rateLimiter() {
        RateLimiterConfig config = RateLimiterConfig.custom()
            .limitForPeriod(100)
            .limitRefreshPeriod(Duration.ofSeconds(1))
            .timeoutDuration(Duration.ofMillis(500))
            .build();

        return RateLimiterRegistry.of(config).rateLimiter("apiRateLimiter");
		// or
		// return RateLimiter.of("apiRateLimiter", config);
    }

    // 2. 🚪 Bulkhead: 10 concurrent threads
    @Bean
    public Bulkhead bulkhead() {
        BulkheadConfig config = BulkheadConfig.custom()
            .maxConcurrentCalls(10)
            .maxWaitDuration(Duration.ofMillis(100))
            .build();

        return BulkheadRegistry.of(config).bulkhead("apiBulkhead");
    }

    // 3. 🕒 Time Limiter: 3s timeout
    @Bean
    public TimeLimiter timeLimiter() {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
            .timeoutDuration(Duration.ofSeconds(3))
            .build();

        return TimeLimiterRegistry.of(config).timeLimiter("apiTimeLimiter");
    }

    // 4. 🔁 Retry: 3 retries with 1s backoff
    @Bean
    public Retry retry() {
        RetryConfig config = RetryConfig.custom()
            .maxAttempts(3)
            .waitDuration(Duration.ofSeconds(1))
            .retryOnException(e -> !(e instanceof IllegalArgumentException))
            .build();

        return RetryRegistry.of(config).retry("apiRetry");
    }

    // 5. ⚡ Circuit Breaker: Open after 50% failure rate
    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
            .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
            .slidingWindowSize(10)
            .failureRateThreshold(50)
            .waitDurationInOpenState(Duration.ofSeconds(30))
            .build();

        return CircuitBreakerRegistry.of(config).circuitBreaker("apiCircuitBreaker");
    }
}

