/**
 * 
 */
package com.techbytes.jwtdemo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author andyn
 *
 */
@Service
public class UserService implements UserDetailsService {

	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		/*
		 *  logic to get the user from database
		 *   User user=userRepository.findByUsername(username);
		 *   return spring user as below with username,password and granted authority
		 *   return new User(user.getUsername(),user.getPassword(),new ArrayList<T>());
		 */
		/*
		 * currently we are hardcoding the user as below
		 */
		return new User("admin","password",new ArrayList());
	}

}
