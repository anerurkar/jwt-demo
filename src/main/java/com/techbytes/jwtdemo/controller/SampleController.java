/**
 * 
 */
package com.techbytes.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbytes.jwtdemo.model.JwtReq;
import com.techbytes.jwtdemo.model.JwtResp;
import com.techbytes.jwtdemo.service.UserService;
import com.techbytes.jwtdemo.util.JWTUtility;

/**
 * @author andyn
 *
 */

@RestController
public class SampleController {
	
	 @Autowired
	    private JWTUtility jwtUtility;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserService userService;
	    
	    
	@GetMapping("/sample")
	public String welcome() {
		
		return "Welcome To JWT Authentication-Text Based Password";
	}
	
	@PostMapping("/authenticate")
    public JwtResp authenticate(@RequestBody JwtReq jwtReq) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtReq.getUserName(),
                            jwtReq.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
// load user from service
        final UserDetails userDetails
                = userService.loadUserByUsername(jwtReq.getUserName());
// generate token
        final String token =
                jwtUtility.generateToken(userDetails);
// return token in response
        return  new JwtResp(token);
    }

}
