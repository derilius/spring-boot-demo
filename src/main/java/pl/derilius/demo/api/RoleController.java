package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.domain.studies.dto.PersonDTO;
import pl.derilius.demo.domain.user.RoleService;
import pl.derilius.demo.domain.studies.dto.RoleDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
@Api(tags = "Role", produces = "application/json", consumes = "application/json")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping("/{name}")
    public ResponseEntity<RoleDTO> create(
            @PathVariable String name
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
