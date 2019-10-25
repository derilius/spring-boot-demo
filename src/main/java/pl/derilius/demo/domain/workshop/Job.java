package pl.derilius.demo.domain.workshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;

@Entity
@Table(schema = "workshop", name = "job")
@SequenceGenerator(schema = "workshop", name = "job_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
class Job extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "job_seq_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "`desc`")
    private String desc;

    public Job(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
