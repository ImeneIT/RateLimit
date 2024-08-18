package com.example.resilience4j;


import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class RateLimitController {


    private final BackendService backendService;

    public RateLimitController(BackendService backendService) {
        this.backendService = backendService;
    }

    @GetMapping("/backend")
    public String backendEndpoint() {
        return backendService.backendMethod();
    }

    @ExceptionHandler(RequestNotPermitted.class)
    public void handleRequestNotPermitted(RequestNotPermitted ex) {
        throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Rate limit exceeded");
    }
}