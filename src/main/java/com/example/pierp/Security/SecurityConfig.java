package com.example.pierp.Security;

import com.example.pierp.Security.UserDetails.PersonneDetailsService;
import jakarta.websocket.ClientEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
   private PersonneDetailsService personneDetailsService;

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User
                .builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails user2 = User
                .builder()
                .username("responsable")
                .password(passwordEncoder().encode("responsable"))
                .roles("RESPONSABLE")
                .build();
        UserDetails user3 = User
                .builder()
                .username("Houssema")
                .password(passwordEncoder().encode("Zammali"))
                .roles("TECHNICIEN")
                .build();
        UserDetails user4 = User
                .builder()
                .username("Maissa")
                .password(passwordEncoder().encode("Jhonny"))
                .roles("TAPISSIER")
                .build();
        return new InMemoryUserDetailsManager(user,user2,user3,user4);
    }
    @Bean
    public UserDetailsService userDetailsService2(){
        return personneDetailsService;
    }
     @Bean
     public DaoAuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
         daoAuthenticationProvider.setUserDetailsService(userDetailsService2());
         return daoAuthenticationProvider;
     }
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .cors().and()
                .authorizeHttpRequests((aux)->aux
                        .requestMatchers(new AntPathRequestMatcher("/tache/**")).hasAnyAuthority("RESPONSABLE","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/facture/**")).hasAnyAuthority("RESPONSABLE","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/garantie/**")).hasAnyAuthority("RESPONSABLE","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/piece/**")).hasAnyAuthority("RESPONSABLE","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/client/**")).hasAnyAuthority("RESPONSABLE","ADMIN","PARTENAIRE","COMMERCIAL","TECHNICIEN")
                        .requestMatchers(new AntPathRequestMatcher("/vehicule/**")).hasAnyAuthority("RESPONSABLE","ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/personne/**")).hasAnyAuthority("RESPONSABLE","ADMIN","TECHNICIEN")

                        .anyRequest().authenticated()
                )
               .httpBasic(Customizer.withDefaults())
               .authenticationProvider(authenticationProvider());
        return http.build();

    }


}

