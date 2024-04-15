package org.example.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;

import feign.RequestInterceptor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;


@RequiredArgsConstructor
public class OAuthFeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        final String authorization = HttpHeaders.AUTHORIZATION;
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String tokenValue;
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken){
            tokenValue = jwtAuthenticationToken.getToken().getTokenValue();

        } else {
            tokenValue = "";
        }
        return requestTemplate -> {
            requestTemplate.header(authorization, "Bearer " + tokenValue);
        };
    }
}
