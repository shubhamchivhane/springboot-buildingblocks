package com.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.UserDetails;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello()
	{
		return "hellow";
	}
	
	
	@GetMapping("/getUser")
	public UserDetails getUser()
	{
		UserDetails user=new UserDetails();
		user.setFirstName("Shubham");
		user.setLastName("Chivhane");
		user.setCity("Hydrabad");
		return user;
	}
}
