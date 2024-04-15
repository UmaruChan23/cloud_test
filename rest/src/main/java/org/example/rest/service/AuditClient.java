package org.example.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feign-rest",
        url = "http://feign-rest:8087/")
public interface AuditClient {

    @GetMapping("/audit")
    ResponseEntity<String> getHello();
}
