package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.derilius.demo.domain.studies.TransactionService;
import pl.derilius.demo.domain.studies.dto.PropertyAPI;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;
import pl.derilius.demo.domain.studies.dto.TransactionAPI;
import pl.derilius.demo.domain.studies.dto.TransactionDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
@Api(tags = "Transaction", produces = "application/json", consumes = "application/json")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController( TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }
    
    @PostMapping
    public ResponseEntity<TransactionDTO> create(
            @RequestBody TransactionAPI api
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.create(api));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> read(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(transactionService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody TransactionAPI api
    ) {
        transactionService.update(id, api);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
