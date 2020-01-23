package pl.derilius.demo.domain.studies;

import pl.derilius.demo.domain.studies.dto.PersonDTO;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;
import pl.derilius.demo.domain.studies.dto.RoleDTO;
import pl.derilius.demo.domain.studies.dto.TransactionDTO;
import pl.derilius.demo.domain.user.Person;
import pl.derilius.demo.domain.user.Role;

public class Mapper {

    static PropertyDTO toPropertyDTO(Property p) {
        return PropertyDTO.builder()
                .id(p.getId())
                .type(p.getType())
                .area(p.getArea())
                .roomsNumber(p.getRoomsNumber())
                .roomsFloors(p.getFloorsNumber())
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
                .personName(t.getPerson().getFirstName() + ' ' + t.getPerson().getLastName())
                .build();
    }

    static PersonDTO toPersonDTO(Person p) {
        return PersonDTO.builder()
                .id(p.getId())
                .firstName(p.getFirstName())
                .lastName(p.getLastName())
                .address(p.getAddress())
                .telephone(p.getTelephone())
                .pesel(p.getPesel())
                .salary(p.getSalary())
                .birthday(p.getBirthday())
                .workedDate(p.getWorkedDate())
                .roleId(p.getRole().getId())
                .roleName(p.getRole().getName())
                .build();
    }

    public static RoleDTO toRoleDTO(Role r) {
        return RoleDTO.builder()
                .id(r.getId())
                .name(r.getName().toString())
                .build();
    }

}
