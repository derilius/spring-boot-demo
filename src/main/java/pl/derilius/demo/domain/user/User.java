package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.derilius.demo.domain.user.dto.RegisterApi;

@Getter
@AllArgsConstructor
class User {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    User(RegisterApi api, String password) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
        this.username = api.getUsername();
        this.password = password;
    }

}
