package pl.derilius.demo.domain.studies.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String telephone;

    private String pesel;

    private double salary;

    private LocalDate birthday;

    private LocalDate workedDate;

    private Long roleId;
    private String roleName;

}
