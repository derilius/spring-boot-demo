package pl.derilius.demo.domain.studies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.studies.dto.TransactionDTO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(Mapper::toTransactionDTO)
                .collect(Collectors.toList());
    }
}
