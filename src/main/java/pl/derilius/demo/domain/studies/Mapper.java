package pl.derilius.demo.domain.studies;

import pl.derilius.demo.domain.studies.dto.PropertyDTO;
import pl.derilius.demo.domain.studies.dto.TransactionDTO;

public class Mapper {

    static PropertyDTO toPropertyDTO(Property p) {
        return PropertyDTO.builder()
                .id(p.getId())
                .type(p.getType())
                .area(p.getArea())
                .roomsNumber(p.getRoomsNumber())
                .roomsFloors(p.getRoomsFloors())
                .floor(p.getFloor())
                .price(p.getPrice())
                .address(p.getAddress())
                .condition(p.getCondition())
                .handingDate(p.getHandingDate())
                .build();
    }

    static TransactionDTO toTransactionDTO(Transaction t) {
        return TransactionDTO.builder()
                .id(t.getId())
                .date(t.getDate())
                .price(t.getPrice())
                .propertyId(t.getProperty().getId())
                .propertyAddress(t.getProperty().getAddress())
                .personId(t.getPerson().getId())
                .personName(t.getPerson().getFirstName() + ' ' + t.getPerson().getFirstName())
                .build();
    }

}
