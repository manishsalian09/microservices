package org.trident.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.trident.security.dto.AccountDTO;
import org.trident.security.dto.UserDetailsDTO;
import org.trident.security.proxy.AccountServiceProxy;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountServiceProxy accountServiceProxy;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final AccountDTO accountDTO = accountServiceProxy.findAccountByUserId(username).getBody();
		return new UserDetailsDTO(accountDTO);
	}

}
