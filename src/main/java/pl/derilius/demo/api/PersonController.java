package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.domain.studies.PersonService;
import pl.derilius.demo.domain.studies.PropertyService;
import pl.derilius.demo.domain.studies.dto.PersonAPI;
import pl.derilius.demo.domain.studies.dto.PersonDTO;
import pl.derilius.demo.domain.studies.dto.PropertyAPI;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
@Api(tags = "Person", produces = "application/json", consumes = "application/json")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController( PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping()
    public ResponseEntity<PersonDTO> create(
            @RequestBody PersonAPI api
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(api));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> read(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(personService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody PersonAPI api
    ) {
        personService.update(id, api);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
