package pl.polsl.rtc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.User;

import java.util.*;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowercaseLogin = username.toLowerCase();
        User user = userRepository.findUserByUsername(lowercaseLogin);

        if(user == null) {
            throw new UsernameNotFoundException("Username " + lowercaseLogin + " not found in database");
        }

        return UserConstruct(user);
    }

    public org.springframework.security.core.userdetails.User UserConstruct(User user) {

        GrantedAuthority grantedAuth = new SimpleGrantedAuthority(user.getAuthority());
        List<GrantedAuthority> grantedAuthorities = Arrays.asList(grantedAuth);

        return new org.springframework.security.core.userdetails.User(user.getUsername().toLowerCase(), user.getPassword()
                , grantedAuthorities);
    }

}
