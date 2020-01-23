package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.derilius.demo.domain.studies.PropertyService;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/property")
@Api(tags = "Property", produces = "application/json", consumes = "application/json")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyDTO>> getAll() {
        return ResponseEntity.ok(propertyService.getAll());
    }

}
