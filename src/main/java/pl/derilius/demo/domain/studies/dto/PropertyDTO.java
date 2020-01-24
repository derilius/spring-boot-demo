package pl.derilius.demo.domain.studies.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PropertyDTO {

    private Long id;

    private String type;

    private double area;

    private int roomsNumber;

    private int roomsFloors;

    private int floor;

    private double price;

    private String address;

    private String condition;

    private LocalDate handingDate;

    private Long personId;

    private String personName;

}
