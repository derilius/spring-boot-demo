package pl.derilius.demo.domain.studies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.derilius.demo.domain.studies.dto.PropertyAPI;
import pl.derilius.demo.utils.AbstractModel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "properties")
@SequenceGenerator(schema = "public", name = "property_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class Property extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "property_seq_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "area")
    private double area;

    @Column(name = "rooms_number")
    private int roomsNumber;

    @Column(name = "floors_number")
    private int floorsNumber;

    @Column(name = "floor")
    private int floor;

    @Column(name = "price")
    private double price;

    @Column(name = "address")
    private String address;

    @Column(name = "condition")
    private String condition;

    @Column(name = "handing_date")
    private LocalDate handingDate;

    public Property(PropertyAPI api) {
        this.type = api.getType();
        this.area = api.getArea();
        this.floorsNumber = api.getFloorsNumber();
        this.roomsNumber = api.getRoomsNumber();
        this.floor = api.getFloor();
        this.price = api.getPrice();
        this.address = api.getAddress();
        this.condition = api.getCondition();
        this.handingDate = LocalDate.parse(api.getHandingDate());
    }

    public void update(PropertyAPI api) {
        this.type = api.getType();
        this.area = api.getArea();
        this.floorsNumber = api.getFloorsNumber();
        this.roomsNumber = api.getRoomsNumber();
        this.floor = api.getFloor();
        this.price = api.getPrice();
        this.address = api.getAddress();
        this.condition = api.getCondition();
        this.handingDate = LocalDate.parse(api.getHandingDate());
    }
}
