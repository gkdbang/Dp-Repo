package com.quinnox.qtvt.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.quinnox.qtvt.service.EmployeeService;



/**
 * @author 
 *
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private LdapConfiguration ldapConfiguration;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String username = auth.getName();
		final String password = auth.getCredentials().toString();
		Map<String, String> ldapUserMap=null;
		try {
			ldapUserMap = ldapConfiguration.authenticateEmployee(username, password);
			if(ldapUserMap!=null && employeeService.findUserById(ldapUserMap.get("employeeNumber"))==null) {
				employeeService.createUserdata(ldapUserMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ldapUserMap==null){
	    	  throw new BadCredentialsException("External system authentication failed");
	      }
		final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
		authenticationToken.setDetails(ldapUserMap);
		return authenticationToken;
	}


	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}
}
