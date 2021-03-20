package com.user.controller.servceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.controller.servcei.UserService;
import com.user.exception.UserExistException;
import com.user.exception.UserNotFoundException;
import com.user.model.UserDetails;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails saveUser(UserDetails user) throws UserExistException {
		UserDetails existingUser= getUserByName(user.getUserName());
		System.out.println("Existing user "+existingUser);
		if(existingUser == null)
		{
			return repo.save(user);
		}
		else
		{
			throw new UserExistException("User Already Exist username "+user.getUserName());
		} 
		
		
	}

	@Override
	public Optional<UserDetails> getUserById(int id) throws UserNotFoundException {

		Optional<UserDetails> opt = repo.findById(id);
		if (!opt.isPresent()) {
			throw new UserNotFoundException("User not found with id :" + id);
		}
		return opt;
	}

	@Override
	public UserDetails getUserByName(String name) {

		return repo.findByUserName(name);
	}

	@Override
	public List<UserDetails> getAllUser() {

		return repo.findAll();
	}

	@Override
	public UserDetails updateUserById(int id, UserDetails user) throws UserNotFoundException {
       Optional<UserDetails> records=getUserById(id);
		user.setId(id);
		return repo.save(user);

	}

}
