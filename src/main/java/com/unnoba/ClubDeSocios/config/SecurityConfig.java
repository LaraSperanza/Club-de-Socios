package com.unnoba.ClubDeSocios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
    http 
    .userDetailsService(userDetailsService) 
    .authorizeHttpRequests((requests)->requests 
      .requestMatchers("/webjars/**","/resources/**","/css/**")
      .permitAll() 
      .requestMatchers("/")
      .permitAll() 
      .anyRequest()
      .authenticated() ) 
    .formLogin((form)->form.permitAll()
    .loginPage("/login")
    )
    .logout((logout)->logout.permitAll()); 
    return http.build();
  }

  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
