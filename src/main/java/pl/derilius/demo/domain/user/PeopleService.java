package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.user.dto.RegisterApi;

@Service
class PeopleService {

    private final PeopleRepository repository;

    @Autowired
    PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    People create(RegisterApi api) {
        People people = new People(api);
        return repository.save(people);
    }

}
