package com.springproject.movies.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withUsername("utkarsh")
      .password(passwordEncoder().encode("Hq@1ewrretrye"))
      .roles("ADMIN")
      .build();
    return new InMemoryUserDetailsManager(user);
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .cors(cors->cors.disable())
        .authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
        return http.build();
    }
}