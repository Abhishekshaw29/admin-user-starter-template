package com.exam.portal;

import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.portal.models.User;
import com.exam.portal.models.UserPackages;
import com.exam.portal.repo.UserRepository;

@SpringBootApplication
public class PortalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("I am running fine");

	}

}
