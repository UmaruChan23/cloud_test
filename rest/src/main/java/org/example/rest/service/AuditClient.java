package org.example.rest.service;

import org.example.rest.config.OAuthFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feign-rest",
        url = "http://feign-rest:8087/",
        configuration = OAuthFeignConfig.class)
public interface AuditClient {

    @GetMapping("/audit")
    ResponseEntity<String> getHello();
}
