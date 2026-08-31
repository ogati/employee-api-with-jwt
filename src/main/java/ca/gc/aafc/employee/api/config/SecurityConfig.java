package ca.gc.aafc.employee.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ca.gc.aafc.employee.api.auth.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
//        	.csrf(csrf -> csrf.disable()) // uncommented out in header-based authN
        	.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> 
            	auth.requestMatchers(              // rule 1
            			"/index.html",
            			"/login",
            			"/h2-console/**")
            		.permitAll()
	                .requestMatchers("/admin/**")  // rule 2
	                .hasRole("ADMIN")
	                .anyRequest()                  // rule 3
	                .authenticated())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));     // removed in prod
        
        return http.build();
    }
	
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
