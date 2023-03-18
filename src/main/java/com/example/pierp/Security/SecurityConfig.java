package com.example.pierp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(org.springframework.security.core.userdetails.User.withUsername("admin").password(bCryptPasswordEncoder.encode("admin")).roles("RESPONSABLE").build());
        return manager;
    }
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable();
        http
                .cors()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/personne")
                .permitAll()
                .anyRequest()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/personne/logout",HttpMethod.POST.toString()))
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


}

