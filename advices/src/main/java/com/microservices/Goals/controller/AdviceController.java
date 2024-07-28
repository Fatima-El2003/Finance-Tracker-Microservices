package com.microservices.Goals.controller;

import com.microservices.Goals.model.Advice;
import com.microservices.Goals.service.AdviceService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {
     private final AdviceService adviceService;
     @Autowired
     public AdviceController(final AdviceService adviceService) {
         this.adviceService = adviceService;
     }
    @PostMapping
    public ResponseEntity<Advice> createAdvice(@RequestBody Advice advice) {
        Advice savedAdvice = adviceService.addAdvice(advice);
        return ResponseEntity.ok(savedAdvice);
    }
    @GetMapping
    public ResponseEntity<List<Advice>> getAllAdvices() {
         return ResponseEntity.ok(adviceService.getAllAdvices());
    }
    @GetMapping("{idAdvice}")
    public ResponseEntity<Advice> getAdviceById(@PathVariable("idAdvice") Long idAdvice){
        return ResponseEntity.ok(adviceService.getAdviceById(idAdvice));
    }

    @DeleteMapping("{idAdvice}")
    public ResponseEntity<String> deleteAdvice(@PathVariable("idAdvice") Long idAdvice) {
         adviceService.deleteAdvice(idAdvice);
         return ResponseEntity.ok("Advice Deleted");
    }
    //supposing we are making a request to another service, implementing the circuit breaker
    // to handle the service failure so instead of waiting the response from this
    // failed service we execute the fallback methode
    /* @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        log.info("Cannot Place Order Executing Fallback logic");
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please order after some time!");
    }*/
}
