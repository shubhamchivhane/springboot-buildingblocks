package com.user.controller.servcei;

import java.util.List;
import java.util.Optional;

import com.user.model.UserDetails;


public interface UserService {
	
	UserDetails saveUser(UserDetails user);
	Optional<UserDetails> getUserById(int id);
	UserDetails getUserByName(String name);
	List<UserDetails> getAllUser();
	UserDetails updateUserById(int id, UserDetails user);

}
