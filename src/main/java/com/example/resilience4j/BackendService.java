package com.example.resilience4j;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class BackendService {

    @RateLimiter(name = "backendA")
    public String backendMethod() {
        // Your service logic here
        return "Response from backend";
    }
}
