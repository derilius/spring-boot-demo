package pl.derilius.demo.domain.studies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyAPI {

    private String type;

    private double area;

    private int roomsNumber;

    private int floorsNumber;

    private int floor;

    private double price;

    private String address;

    private String condition;

    private String handingDate;

}
