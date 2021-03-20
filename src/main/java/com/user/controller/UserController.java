package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.controller.servcei.UserService;
import com.user.model.UserDetails;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService service;

	@PostMapping
	private UserDetails saveUser(@RequestBody UserDetails user)
	{ 
		return service.saveUser(user);
	}
	
	@GetMapping
	private List<UserDetails> getAllUser()
	{
		return service.getAllUser();
	}
	
	@GetMapping("/{id}")
	private UserDetails getUser(@PathVariable int id)
	{
		return service.getUserById(id);
	}
	
	@GetMapping("/{name}")
	private UserDetails getUserbyName(@PathVariable String name)
	{
		return service.getUserByName(name);
	}
	
	@PutMapping("/{id}")
	private UserDetails updateUser(@PathVariable int id,@RequestBody UserDetails user)
	{
		return service.updateUserById(id, user);
	}
	
}
