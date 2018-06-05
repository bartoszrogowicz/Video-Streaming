package pl.polsl.rtc.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ManagedUser extends UserDTO{

    public static final int minPasswordLength = 5;

    public static final int maxPasswordLength = 30;

    @Size(min = minPasswordLength , max = maxPasswordLength)
    private String password;

    public ManagedUser() {
    }

    public ManagedUser(long id, String username,  String password) {
        super(id, username);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
