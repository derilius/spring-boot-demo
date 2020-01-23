package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.domain.studies.PropertyService;
import pl.derilius.demo.domain.studies.dto.PropertyAPI;
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

    @PostMapping()
    public ResponseEntity<PropertyDTO> create(
            @RequestBody PropertyAPI api
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.create(api));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> read(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(propertyService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody PropertyAPI api
    ) {
        propertyService.update(id, api);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
