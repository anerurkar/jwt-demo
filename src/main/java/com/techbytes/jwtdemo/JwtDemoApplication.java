package com.techbytes.jwtdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.techbytes.jwtdemo.model.User;
import com.techbytes.jwtdemo.repository.UserRepository;

@SpringBootApplication
public class JwtDemoApplication {
	  @Autowired
	    private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	   @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(102, "andy", "password", "andyn@gmail.com"),
	                new User(103, "pandy", "pass1", "pandy@gmail.com"),
	                new User(104, "sandy", "pass2", "sandy@gmail.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }
}
