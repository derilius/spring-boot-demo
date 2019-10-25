package pl.derilius.demo.domain.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "client", name = "vehicle")
@SequenceGenerator(schema = "vehicle", name = "vehicle_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class Vehicle extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vehicle_seq_id")
    private Long id;

    @Column(name = "people_id")
    private Long peopleId;

    @Column(name = "name")
    private String name;

}
