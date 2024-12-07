package org.joksin.springsociallogin.idms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
//                           .authorizeHttpRequests(auth -> auth.requestMatchers("/api/sessions/*").permitAll().anyRequest().authenticated())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
                })
                .build();
    }
}
