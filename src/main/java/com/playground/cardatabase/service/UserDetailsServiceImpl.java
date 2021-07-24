package com.playground.cardatabase.service;

import com.playground.cardatabase.domain.User;
import com.playground.cardatabase.repository.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUserName(userName);
        
        return new org.springframework.security.core.userdetails.User(
            userName, currentUser.getPassword(),
            true, true, true, true,
            AuthorityUtils.createAuthorityList(currentUser.getRole())
        );
    }
}
