/**
 * 
 */
package com.techbytes.jwtdemo.model;

import java.io.Serializable;

/**
 * @author andyn
 *
 */
public class JwtReq implements Serializable {

	String userName;
	String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtReq(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public JwtReq() {
		super();
		
	}
	
}
