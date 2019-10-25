package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "workshop", name = "job2order")
@SequenceGenerator(schema = "workshop", name = "job2order_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Job2Order extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "job2order_seq_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

}
