package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.user.dto.RegisterApi;

import java.util.Optional;

@Service
class PeopleService {

    private final PeopleRepository repository;
    private final RoleRepository roleRepository;

    @Autowired
    PeopleService(PeopleRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    Person create(RegisterApi api) {
        Optional<Role> role = roleRepository.findByName("USER");
        Person person = new Person(api, role.get());
        return repository.save(person);
    }

}
