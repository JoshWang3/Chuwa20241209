package com.chuwa.redbook.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityInMemoryConfig {

    /**
     * Register the library provides by the third party to the spring bean factory
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui.html",       // Swagger UI HTML
                                "/swagger-ui/**",         // Swagger UI resources
                                "/v3/api-docs",           // OpenAPI JSON
                                "/v3/api-docs/**",        // OpenAPI JSON
                                "/webjars/**",            // WebJars for Swagger UI
                                "/swagger-resources/**",  // Swagger resources
                                "/configuration/**"       // Swagger configuration
                        ).permitAll()
                        // Allow access to Swagger endpoints
                        .anyRequest().authenticated()) // Require authentication for all other endpoints)
                .httpBasic(withDefaults())
                .build();
    }


    /**
     * The Authentication Provider is backed by a simple, in-memory implementation, InMemoryUserDetailsManager.
     * This is useful for rapid prototyping when a full persistence mechanism is not yet necessary:
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("zifwang")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("zifanw")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }
}
