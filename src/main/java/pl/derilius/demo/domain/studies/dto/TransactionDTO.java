package pl.derilius.demo.domain.studies.dto;

import lombok.Builder;
import lombok.Getter;
import pl.derilius.demo.domain.studies.Property;
import pl.derilius.demo.domain.user.Person;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Builder
@Getter
public class TransactionDTO {

    private Long id;

    private LocalDate date;

    private double price;

    private Long propertyId;
    private String propertyAddress;

    private Long personId;
    private String personName;

}
