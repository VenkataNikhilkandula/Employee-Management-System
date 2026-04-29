//package com.stackly.ems.config;
//
//import org.springframework.context.annotation.*;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import com.stackly.ems.security.JwtFilter;
//
//@Configuration
//public class SecurityConfig {
//
//	
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
//
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//            	    .requestMatchers("/auth/**").permitAll()
//            	    .requestMatchers("/api/employees/**").hasRole("ADMIN")
//            	    .requestMatchers("/api/dashboard/**").hasRole("ADMIN")
//            	    .anyRequest().authenticated()
//            	)
//            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//    
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//   
//}
//
//



package com.stackly.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.stackly.ems.security.JwtFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // सार्वजनिक (no auth required)
                .requestMatchers("/auth/**").permitAll()

                // ADMIN access
                .requestMatchers("/api/employees/**").hasAuthority("ADMIN")
                .requestMatchers("/api/dashboard/**").hasAuthority("ADMIN")

                // any other request must be authenticated
                .anyRequest().authenticated()
            )
            // JWT filter
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
