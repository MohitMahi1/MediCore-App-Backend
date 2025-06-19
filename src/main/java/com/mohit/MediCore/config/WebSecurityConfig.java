package com.mohit.MediCore.config;
// This is for the main web security provide to the our APP
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        try {
            httpSecurity.authorizeHttpRequests((auth) -> auth
                    .requestMatchers(("/**")).permitAll()
                    .anyRequest().authenticated());

            return httpSecurity.build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
