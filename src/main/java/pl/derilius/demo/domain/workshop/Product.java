package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "workshop", name = "product")
@SequenceGenerator(schema = "workshop", name = "product_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Product extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_seq_id")
    private Long id;

    @Column(name = "name")
    private String name;

}
