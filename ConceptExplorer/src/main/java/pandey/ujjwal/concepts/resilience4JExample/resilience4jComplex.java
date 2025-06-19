package pandey.ujjwal.concepts.resilience4JExample;

import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;

@Service
public class resilience4jComplex {
 private final RateLimiter rateLimiter;
    private final Bulkhead bulkhead;
    private final TimeLimiter timeLimiter;
    private final Retry retry;
    private final CircuitBreaker circuitBreaker;
    
    @Autowired
    private ScheduledExecutorService scheduler;

    @Autowired
    public resilience4jComplex(RateLimiter rateLimiter, Bulkhead bulkhead, TimeLimiter timeLimiter, Retry retry, CircuitBreaker circuitBreaker) {
        this.rateLimiter = rateLimiter;
        this.bulkhead = bulkhead;
        this.timeLimiter = timeLimiter;
        this.retry = retry;
        this.circuitBreaker = circuitBreaker;
    }

    public String executeProtectedCall() {
        // Supplier<String> decoratedSupplier = CircuitBreaker
        //     .decorateSupplier(circuitBreaker, () ->
        //         Retry.decorateSupplier(retry, () ->
        //             TimeLimiter.decorateFutureSupplier(timeLimiter, () ->
        //                 Bulkhead.decorateSupplier(bulkhead, () ->
        //                    RateLimiter.decorateSupplier(rateLimiter, this::businessLogic)
        //                 )
        //             )
        //         )
        //     );
        // private String businessLogic() {
        //     // Your actual business logic here
        //     return "Service Result";
        // }
        // return decoratedSupplier.get();

        // OR
        
        // Supplier<CompletableFuture<String>> supplier = () -> CompletableFuture.supplyAsync(() -> {
        //     // simulate call
        //     return "Response!";
        // });
        // return TimeLimiter.decorateFutureSupplier(timeLimiter, supplier)
        //         .andThen(RateLimiter.decorateSupplier(rateLimiter, () -> ""))
        //         .andThen(Bulkhead.decorateSupplier(bulkhead, () -> ""))
        //         .andThen(Retry.decorateSupplier(retry, () -> ""))
        //         .andThen(CircuitBreaker.decorateSupplier(circuitBreaker, () -> "Service success"))
        //         .get();

        // OR

        // Step 1: Original logic wrapped in CompletableFuture - // Simulate external service logic
        Supplier<CompletionStage<String>> futureSupplier = () -> CompletableFuture.supplyAsync(() -> { return "✅ Success from remote API"; });
        // Step 2: Apply TimeLimiter
        Supplier<CompletionStage<String>> timeLimiterSupplier = TimeLimiter.decorateCompletionStage(timeLimiter, scheduler, futureSupplier);
        // Step 3: Bulkhead
        Supplier<CompletionStage<String>> bulkheadSupplier = Bulkhead.decorateCompletionStage(bulkhead, timeLimiterSupplier);
        // Step 4: RateLimiter
        Supplier<CompletionStage<String>> rateLimitedSupplier = RateLimiter.decorateCompletionStage(rateLimiter, bulkheadSupplier);
        // Step 5: Retry
        Supplier<CompletionStage<String>> retrySupplier = Retry.decorateCompletionStage(retry, scheduler, rateLimitedSupplier);
        // Step 6: CircuitBreaker
        Supplier<CompletionStage<String>> circuitBreakerSupplier = CircuitBreaker.decorateCompletionStage(circuitBreaker, retrySupplier);
        // Execute the chain
        return circuitBreakerSupplier.get().toCompletableFuture().toString();
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