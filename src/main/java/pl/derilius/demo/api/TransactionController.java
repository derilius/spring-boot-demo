package pl.derilius.demo.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.derilius.demo.domain.studies.TransactionService;
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

}
