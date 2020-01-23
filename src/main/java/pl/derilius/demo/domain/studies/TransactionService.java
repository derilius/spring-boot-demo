package pl.derilius.demo.domain.studies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.studies.dto.TransactionAPI;
import pl.derilius.demo.domain.studies.dto.TransactionDTO;
import pl.derilius.demo.domain.user.PeopleRepository;
import pl.derilius.demo.domain.user.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final PropertyRepository propertyRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public TransactionService(TransactionRepository repository, PropertyRepository propertyRepository, PeopleRepository peopleRepository) {
        this.repository = repository;
        this.propertyRepository = propertyRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<TransactionDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(Mapper::toTransactionDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO create(TransactionAPI api) {
        Person person = peopleRepository.getOne(api.getPersonId());
        Property property = propertyRepository.getOne(api.getPropertyId());
        Transaction transaction = new Transaction(person, property, api.getPrice());
        transaction = repository.save(transaction);
        return Mapper.toTransactionDTO(transaction);
    }

    public TransactionDTO getOne(Long id) {
        Transaction transaction = repository.getOne(id);
        return Mapper.toTransactionDTO(transaction);
    }

    public void update(Long id, TransactionAPI api) {
        Person person = peopleRepository.getOne(api.getPersonId());
        Property property = propertyRepository.getOne(api.getPropertyId());
        Transaction transaction = repository.getOne(id);
        transaction.update(person, property, api.getPrice());
        repository.save(transaction);
    }

    public void delete(Long id) {
        Transaction transaction = repository.getOne(id);
        transaction.delete();
        repository.save(transaction);
    }

}
