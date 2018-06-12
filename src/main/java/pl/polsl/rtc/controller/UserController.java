package pl.polsl.rtc.controller;

import org.hibernate.procedure.ParameterMisuseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.rtc.entity.User;
import pl.polsl.rtc.service.UserService;
import pl.polsl.rtc.service.dto.ManagedUser;
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

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> addUser(@Valid @RequestBody ManagedUser user) {

        userService.addUser(user);
        //if(!checker) {
         //   return null;
       // }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
