package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "auth", name = "user")
@SequenceGenerator(schema = "auth", name = "user_seq_id")
@Getter
@AllArgsConstructor
@NoArgsConstructor
class User extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    User(RegisterApi api, String password) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
        this.username = api.getUsername();
        this.password = password;
    }

}
