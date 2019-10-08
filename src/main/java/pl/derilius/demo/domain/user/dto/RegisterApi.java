package pl.derilius.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterApi {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
