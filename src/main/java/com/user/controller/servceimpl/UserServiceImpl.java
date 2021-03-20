package com.user.controller.servceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.controller.servcei.UserService;
import com.user.model.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails saveUser(UserDetails user) {
		System.out.println("User details : "+user);
		return repo.save(user);
	}

	@Override
	public UserDetails getUserById(int id) {
		
		return repo.getOne(id);
	}

	@Override
	public UserDetails getUserByName(String name) {
		
		//return repo.findByCity(name);
		return repo.findByUserName(name);
	}

	@Override
	public List<UserDetails> getAllUser() {
		
		return repo.findAll();
	}

	@Override
	public UserDetails updateUserById(int id, UserDetails user) {
		   UserDetails u=getUserById(id);
		   if(!(u == null))
		   {
			   u.setEmailId(user.getEmailId());
			   u.setFirstName(user.getFirstName());
			   u.setLastName(user.getLastName());
			   u.setRole(user.getRole());
			   u.setUserName(user.getUserName());
			   
			   return repo.save(u);
		   }else
		   {
			   return null; 
		   }
		
	}

}
