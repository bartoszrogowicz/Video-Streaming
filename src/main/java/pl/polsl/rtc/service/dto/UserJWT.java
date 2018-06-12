package pl.polsl.rtc.service.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UserJWT {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public UserJWT() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
