package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.user.People;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "workshop", name = "worker")
@SequenceGenerator(schema = "workshop", name = "worker_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Worker extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "worker_seq_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "employment_date")
    private LocalDateTime employmentDate = LocalDateTime.now();

    public Worker(People people, String pesel) {
        this.people = people;
        this.pesel = pesel;
    }

}
