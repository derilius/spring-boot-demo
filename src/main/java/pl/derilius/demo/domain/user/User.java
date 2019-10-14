package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(schema = "auth", name = "users")
@SequenceGenerator(schema = "auth", name = "user_seq_id", allocationSize = 1)
@Getter
@AllArgsConstructor
@NoArgsConstructor
class User extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq_id")
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

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    User(RegisterApi api, String password, Role role) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
        this.username = api.getUsername();
        this.password = password;
        this.role = role;
    }

    Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissionList().stream()
                .map(permission -> (GrantedAuthority) permission::getPermission)
                .collect(Collectors.toList());
    }

}
