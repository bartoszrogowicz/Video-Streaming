package pl.polsl.rtc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.User;
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
    private UserDTO userDTO;

    public List<UserDTO> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList.stream().map(user -> userDTO.userToUserDTO(user)).collect(Collectors.toList());
    }

    public void deleteUserByLogin(String username) {
        userRepository.deleteUserByUsername(username);
    }

    public boolean addUser(User user) {
        if(user == null) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }
}
