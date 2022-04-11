/**
 * 
 */
package com.techbytes.jwtdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techbytes.jwtdemo.model.User;

/**
 * @author andyn
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String username);
}
