package com.oidc.client;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class OIDCClientIntergationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OIDCClientIntergationApplication.class, args);
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .oauth2Login(withDefaults());
        return http.build();
	}

}
