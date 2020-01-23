package pl.derilius.demo.domain.studies.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleDTO {

    private Long id;
    private String name;

}
