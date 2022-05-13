package com.security.test;

import java.util.Optional;

import com.security.test.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println(user);


        user.orElseThrow(()-> new UsernameNotFoundException(username + "not found"));

        return user.map(MyUserDetails::new).get();
    }

    
    
}
