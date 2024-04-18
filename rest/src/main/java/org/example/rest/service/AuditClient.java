package org.example.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feign-service")
public interface AuditClient {

    @GetMapping("/audit")
    ResponseEntity<String> getHello();
}
