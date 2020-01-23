package pl.derilius.demo.domain.studies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.user.Person;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "transactions")
@SequenceGenerator(schema = "public", name = "transaction_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class Transaction extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "transaction_seq_id")
    private Long id;

    @Column(name = "`date`")
    private LocalDate date;

    @Column(name = "`price`")
    private double price;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Transaction(Person person, Property property, double price) {
        this.date = LocalDate.now();
        this.price = price;
        this.person = person;
        this.property = property;
    }

    public void update(Person person, Property property, double price) {
        this.price = price;
        this.person = person;
        this.property = property;
    }
}
