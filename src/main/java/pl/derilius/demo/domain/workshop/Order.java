package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.client.Vehicle;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "workshop", name = "order")
@SequenceGenerator(schema = "workshop", name = "order_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Order extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_seq_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Order(Worker worker, Vehicle vehicle) {
        this.worker = worker;
        this.vehicle = vehicle;
    }

}
