package pl.derilius.demo.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "auth", name = "role2permission")
@SequenceGenerator(schema = "auth", name = "role2permission_seq_id", allocationSize = 1)
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Role2Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role2permission_seq_id")
    private Long id;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "permission_id", nullable = false)
    private Long permissionId;

}

