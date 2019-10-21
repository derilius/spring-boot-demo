package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "auth", name = "permissions")
@SequenceGenerator(schema = "auth", name = "permission_seq_id", allocationSize = 1)
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "permission_seq_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "permission", nullable = false)
    private String permission;

    static Permission systemUserRole() {
        return new Permission(null, "user", "SYSTEM", "ROLE_USER");
    }

}

