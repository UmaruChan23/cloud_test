package org.example.feignrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {

    private static final Logger log = LoggerFactory.getLogger(FeignController.class);

    @GetMapping("/audit")
    @PreAuthorize("hasRole('cloud-admin')")
    public ResponseEntity<String> getHello(@AuthenticationPrincipal Jwt principal,
                                           @RequestHeader("Authorization") String authorization) {
        System.out.println(authorization);
        var userId = principal.getClaimAsString("user_id");
        var name = principal.getClaimAsString("name");
        log.info("hello {}. user_id={}", name, userId);
        return ResponseEntity.ok().body(userId);
    }
}
