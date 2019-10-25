package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "workshop", name = "product2orderjob")
@SequenceGenerator(schema = "workshop", name = "product2orderjob_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Product2OrderJob extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product2orderjob_seq_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "job2order_id")
    private Job2Order job2Order;

}
