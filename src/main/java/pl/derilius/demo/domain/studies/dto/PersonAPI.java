package pl.derilius.demo.domain.studies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonAPI {

    private String firstName;

    private String lastName;

    private String address;

    private String telephone;

    private String pesel;

    private double salary;

    private String birthday;

    private String workedDate;

    private Long roleId;

}
