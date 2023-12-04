package com.unnoba.ClubDeSocios.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.unnoba.ClubDeSocios.services.UserDetailsServiceImp;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService(){
    return new UserDetailsServiceImp();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean //DaoAuthenticationProvider es una implementación del AuthenticationProvider. Se utiliza para autenticar usuarios en bases de datos y verificar las credenciales.
  public DaoAuthenticationProvider authenticationProvider(){ 
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
        return authenticationManagerBuilder.build();
    }

  @Bean //SecurityFilterChain define las reglas de autorización para las solicitudes HTTP
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http.authorizeHttpRequests(
      auth -> auth
              .requestMatchers("/resources/**","/css/**", "/assets/**").permitAll()
              .requestMatchers("/dashboard").hasAnyAuthority("ADMIN", "USER")
              .anyRequest().authenticated())

      .formLogin(form -> form.loginPage("/").defaultSuccessUrl("/dashboard").permitAll())
      .logout(logout -> logout.permitAll())
      .exceptionHandling(e -> e.accessDeniedPage("/403"));
    return http.build();
  }

}
