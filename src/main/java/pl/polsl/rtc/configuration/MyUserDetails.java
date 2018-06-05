package pl.polsl.rtc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.User;

import java.util.Optional;

//@Component("userDetailsService")
//@Transactional

public class MyUserDetails {//implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        String lowercaseLogin = email.toLowerCase();
//        Optional<User> userByEmailFromDatabase = userRepository.findUserByEmail(lowercaseLogin);
//
//        if (!userByEmailFromDatabase.isPresent()) {
//            throw new UsernameNotFoundException("Username " + lowercaseLogin + " not found in database");
//        }
//        return ;
//        /*return UserConstruct(userByEmailFromDatabase.get().getEmail(),
//                userByEmailFromDatabase.get().getPassword(),
//                getAuthorities(userByEmailFromDatabase.get().getRoles()));*/
//    }
}
