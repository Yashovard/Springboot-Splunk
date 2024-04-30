package com.learn.SpringbootSecurity.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.learn.SpringbootSecurity.model.User;

@Service
public class UserServices {
	List<User> list=new ArrayList<>();

	public UserServices() {
		list.add(new User("abc", "abc", "abc@gmail.com"));
		list.add(new User("xyz", "xyz", "xyz@gmail.com"));
	}

	public List<User> getAllUser()
	{

		return this.list;
	}


	public User getUser(String username) {
		List<User> userList=new ArrayList<>();
		list.add(new User("abc", "abc", "abc@gmail.com"));
		list.add(new User("xyz", "xyz", "xyz@gmail.com"));
		User user=list.get(0);


		return user;
	}


	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}

}
