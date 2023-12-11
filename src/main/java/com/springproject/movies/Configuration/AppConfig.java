package com.springproject.movies.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {  

/*
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withUsername("utkarsh")
        .password(passwordEncoder().encode("Hq@1ewrretrye"))
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user);
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .cors(cors->cors.disable())
        .authorizeHttpRequests((authz) -> authz
        .requestMatchers("/api/**").hasRole("ADMIN")
        .requestMatchers("/swagger-ui/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
    }

}
