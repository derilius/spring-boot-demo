package pl.derilius.demo.domain.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.user.People;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "client", name = "client")
@SequenceGenerator(schema = "client", name = "client_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Client extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "client_seq_id")
    private Long id;

    @OneToMany(mappedBy = "peopleId")
    private List<Vehicle> vehicles;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @Column(name = "name")
    private String name;

    public Client(People people, String name) {
        this.people = people;
        this.name = name;
    }

}
