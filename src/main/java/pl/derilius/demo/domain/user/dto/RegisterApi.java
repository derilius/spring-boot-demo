package pl.derilius.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterApi {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
