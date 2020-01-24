package pl.derilius.demo.domain.studies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.studies.dto.PropertyAPI;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;
import pl.derilius.demo.domain.user.PeopleRepository;
import pl.derilius.demo.domain.user.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository repository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public PropertyService(PropertyRepository repository, PeopleRepository peopleRepository) {
        this.repository = repository;
        this.peopleRepository = peopleRepository;
    }

    public List<PropertyDTO> getAll() {
        return repository.findAllByDeletedAtIsNull()
                .stream()
                .map(Mapper::toPropertyDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO create(PropertyAPI api) {
        Person person = peopleRepository.getOne(api.getPersonId());
        Property property = new Property(api, person);
        property = repository.save(property);
        return Mapper.toPropertyDTO(property);
    }

    public PropertyDTO getOne(Long id) {
        Property property = repository.getOne(id);
        return Mapper.toPropertyDTO(property);
    }

    public void update(Long id, PropertyAPI api) {
        Person person = peopleRepository.getOne(api.getPersonId());
        Property property = repository.getOne(id);
        property.update(api, person);
        repository.save(property);
    }

    public void delete(Long id) {
        Property property = repository.getOne(id);
        property.delete();
        repository.save(property);
    }

}
