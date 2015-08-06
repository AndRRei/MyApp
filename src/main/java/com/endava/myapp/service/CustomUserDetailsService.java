package com.endava.myapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.myapp.dao.UserDAO;
import com.endava.myapp.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	private UserDAO userDAO = new UserDAO();
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserDetails user = null;
		try {
			
			UserDAO dbUser = userRepository.findUserByUsername(username);
			

			user = new User(dbUser.getUsername(), dbUser.getPassword()
					.toLowerCase(), true, true, true, true,
					getAuthorities(dbUser.getRole().getId()));

		} catch (Exception e) {
			System.out.println(e.toString());
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		authList.add(new GrantedAuthorityImpl("ROLE_USER"));

		if (access.compareTo(2) == 0) {
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}

		return authList;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}