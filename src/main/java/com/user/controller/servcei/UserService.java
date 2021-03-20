package com.user.controller.servcei;

import java.util.List;

import com.user.model.UserDetails;


public interface UserService {
	
	UserDetails saveUser(UserDetails user);
	UserDetails getUserById(int id);
	UserDetails getUserByName(String name);
	List<UserDetails> getAllUser();
	UserDetails updateUserById(int id, UserDetails user);

}
