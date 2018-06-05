package pl.polsl.rtc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.User;
import pl.polsl.rtc.service.dto.ManagedUser;
import pl.polsl.rtc.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList.stream().map(user -> new UserDTO().userToUserDTO(user)).collect(Collectors.toList());
    }

    public void deleteUserByLogin(String username) {

        userRepository.deleteUserByUsername(username);
    }

    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }

    public void addUser(ManagedUser user) {
        User newUser = new User();

        if(userRepository.existByEmail(user.getUsername())) {
            throw new RuntimeException("Username already exist");
        }

        System.out.println(user.getUsername());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
    }
}
