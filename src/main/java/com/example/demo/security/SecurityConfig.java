package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                org.springframework.security.core.userdetails.User.withUsername("admin")
                        .password(passwordEncoder().encode("admin"))
                       .roles("ADMIN")
                       .build(),
                org.springframework.security.core.userdetails.User.withUsername("guest")
                       .password(passwordEncoder().encode("guest"))
                       .roles("GUEST")
                       .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/home").authenticated()
                       .anyRequest().denyAll()
                )
               .formLogin(form -> form
                        .loginPage("/login")
                       .defaultSuccessUrl("/home", true)
                       .permitAll()
                )
               .logout(logout -> logout
                       .permitAll()
                )
               .csrf(csrf -> csrf
                       .disable()
                )
               .exceptionHandling(exception -> exception
                       .accessDeniedPage("/login?error=accessDenied")
                );
        return http.build();
    }
}