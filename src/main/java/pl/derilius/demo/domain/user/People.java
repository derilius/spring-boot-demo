package pl.derilius.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "auth", name = "people")
@SequenceGenerator(schema = "auth", name = "people_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class People extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "people_seq_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    People(RegisterApi api) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
    }

}
