package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rest.service.AuditClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class SimpleRestController {

    private final AuditClient auditClient;

    @GetMapping("/hello")
    @PreAuthorize("hasRole('cloud-user')")
    public ResponseEntity<String> getHello() {
        log.info("Получение запроса от gateway, перенаправление другому сервису");
        return auditClient.getHello();
    }
}
