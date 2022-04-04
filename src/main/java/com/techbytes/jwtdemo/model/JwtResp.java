/**
 * 
 */
package com.techbytes.jwtdemo.model;

import java.io.Serializable;

/**
 * @author andyn
 *
 */
public class JwtResp implements Serializable {
String jwtToken;

public JwtResp() {
	super();
	// TODO Auto-generated constructor stub
}

public JwtResp(String jwtToken) {
	super();
	this.jwtToken = jwtToken;
}

/**
 * @return the jwtToken
 */
public String getJwtToken() {
	return jwtToken;
}

/**
 * @param jwtToken the jwtToken to set
 */
public void setJwtToken(String jwtToken) {
	this.jwtToken = jwtToken;
}

}
