package pl.polsl.rtc.controller;

import org.hibernate.procedure.ParameterMisuseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.rtc.entity.User;
import pl.polsl.rtc.service.UserService;
import pl.polsl.rtc.service.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> addUser(@Valid User user) {

        boolean checker = userService.addUser(user);
        if(!checker) {
            throw new ParameterMisuseException("Some value is empty");
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@Valid @RequestParam("id") String login) {
        userService.deleteUserByLogin(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
