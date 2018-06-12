package pl.polsl.rtc.service.dto;

import pl.polsl.rtc.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


public class UserDTO {

    private long id;

    @NotBlank
    @Size(min = 3)
    private String username;

    public UserDTO() {
    }

    public UserDTO(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public UserDTO userToUserDTO(User user){
        return new UserDTO(user);
    }

    public User userDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
