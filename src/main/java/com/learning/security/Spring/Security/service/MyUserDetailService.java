package com.learning.security.Spring.Security.service;


import com.learning.security.Spring.Security.model.UserPrincipal;
import com.learning.security.Spring.Security.model.Users;
import com.learning.security.Spring.Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {
   @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USername Not FOund");
        } else {
            System.out.println(user);
            return new UserPrincipal(user);

        }
    }
}
