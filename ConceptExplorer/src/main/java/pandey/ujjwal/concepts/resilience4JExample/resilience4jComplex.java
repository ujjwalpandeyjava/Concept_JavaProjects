package pandey.ujjwal.concepts.resilience4JExample;

import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

@Service
public class resilience4jComplex {
 private final RateLimiter rateLimiter;
    private final Bulkhead bulkhead;
    private final TimeLimiter timeLimiter;
    private final Retry retry;
    private final CircuitBreaker circuitBreaker;

    @Autowired
    public resilience4jComplex(RateLimiter rateLimiter, Bulkhead bulkhead, 
                           TimeLimiter timeLimiter, Retry retry,
                           CircuitBreaker circuitBreaker) {
        this.rateLimiter = rateLimiter;
        this.bulkhead = bulkhead;
        this.timeLimiter = timeLimiter;
        this.retry = retry;
        this.circuitBreaker = circuitBreaker;
    }

    public String executeProtectedCall() {
        Supplier<String> decoratedSupplier = CircuitBreaker
            .decorateSupplier(circuitBreaker, () ->
                Retry.decorateSupplier(retry, () ->
                    TimeLimiter.decorateFutureSupplier(timeLimiter, () ->
                        Bulkhead.decorateSupplier(bulkhead, () ->
                           RateLimiter.decorateSupplier(rateLimiter, this::businessLogic)
                        )
                    )
                )
            );

        return decoratedSupplier.get();
    }

    private String businessLogic() {
        // Your actual business logic here
        return "Service Result";
    }
}

// For complex scenarios, use the functional style for explicit control
// NOTE: change method as per need.
// CircuitBreaker.decorateSupplier(
//   Retry.decorateSupplier(
    // TimeLimiter.decorateFutureSupplier(
    //   Bulkhead.decorateSupplier(
        // RateLimiter.decorateSupplier(/*...*/)
    //   )
    // )
//   )
// )