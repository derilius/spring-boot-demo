package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.core.GrantedAuthority;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(schema = "auth", name = "login")
@SequenceGenerator(schema = "auth", name = "login_seq_id", allocationSize = 1)
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Login extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_seq_id")
    private Long id;

    @Column(name = "mail", nullable = false)
    @NotBlank
    private String mail;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "people_id", nullable = false)
    private People people;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "active", nullable = false)
    @NotNull
    private boolean active = false;

    @Column(name = "activate_token")
    private String activateToken = RandomString.make(10);

    @Column(name = "password_token")
    private String passwordToken;

    Login(String mail, String password, Role role, People people) {
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.people = people;
    }

    Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getPermissionList().stream()
                .map(permission -> (GrantedAuthority) permission::getPermission)
                .collect(Collectors.toList());
    }

    void activate() {
        this.active = true;
        this.activateToken = null;
    }

    void remindPassword() {
        this.passwordToken = RandomString.make(10);
    }

    void resetPassword(String newPasswordEncode) {
        this.password = newPasswordEncode;
        this.passwordToken = null;
    }

}
