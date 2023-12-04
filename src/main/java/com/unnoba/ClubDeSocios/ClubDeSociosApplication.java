package com.unnoba.ClubDeSocios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClubDeSociosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubDeSociosApplication.class, args);
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("Hernan123");
		System.out.println("password: "+password);*/
	}
}
