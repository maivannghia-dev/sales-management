package com.example.sales_management.config;

import com.example.sales_management.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products/**", "/categories/**",
                                         "/customers/**", "/orders/**", "/order-details/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/products/**", "/categories/**",
                                         "/customers/**", "/orders/**", "/order-details/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/products/**", "/categories/**",
                                         "/customers/**", "/orders/**", "/order-details/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/products/**", "/categories/**",
                                         "/customers/**", "/orders/**", "/order-details/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}