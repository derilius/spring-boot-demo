package pl.derilius.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(schema = "auth", name = "roles")
@SequenceGenerator(schema = "auth", name = "role_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role_seq_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private Name name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "auth", name = "role2permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Collection<Permission> permissionList = new ArrayList<>();

    Role(Name userRoleName, List<Permission> permissions) {
        this.name = userRoleName;
        this.permissionList = permissions;
    }

    public enum Name {
        /**
         * {@code Administrator}
         */
        ADMIN,

        /**
         * {@code Użytkownik}
         */
        USER,

    }

}
