package pl.derilius.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(schema = "public", name = "roles")
@SequenceGenerator(schema = "public", name = "role_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role_seq_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private Name name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "public", name = "role2permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Collection<Permission> permissionList = new ArrayList<>();

    Role(Name userRoleName) {
        this.name = userRoleName;
        this.permissionList = new ArrayList<>();
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
