package pl.derilius.demo.domain.studies.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class TransactionAPI {

    private double price;

    private Long propertyId;

    private Long personId;

}
