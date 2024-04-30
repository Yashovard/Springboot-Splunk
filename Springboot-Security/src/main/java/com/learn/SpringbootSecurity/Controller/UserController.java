package com.learn.SpringbootSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.SpringbootSecurity.Services.UserServices;
import com.learn.SpringbootSecurity.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices userServices;
	
	

	@GetMapping("/")
	public List<User> getAllUser()
	{
		return this.userServices.getAllUser();

	}
	
	@GetMapping("/username")
	public User getUser(@PathVariable String username)
	{
		return this.userServices.getUser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user)
	{

		return this.userServices.addUser(user);
	}

}
