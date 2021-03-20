package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.user.controller.servcei.UserService;
import com.user.exception.UserExistException;
import com.user.exception.UserNotFoundException;
import com.user.model.UserDetails;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService service;

	@PostMapping
	private UserDetails saveUser(@RequestBody UserDetails user)
	{ 
		try {
			return service.saveUser(user);
		} catch (UserExistException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping
	private List<UserDetails> getAllUser()
	{
		return service.getAllUser();
	}
	
	@GetMapping("/{id}")
	private Optional<UserDetails> getUser(@PathVariable int id)
	{
		try {
			return service.getUserById(id);
		} catch (UserNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/{name}")
	private UserDetails getUserbyName(@PathVariable String name)
	{
		return service.getUserByName(name);
	}
	
	@PutMapping("/{id}")
	private UserDetails updateUser(@PathVariable int id,@RequestBody UserDetails user)
	{
		try {
			return service.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}
