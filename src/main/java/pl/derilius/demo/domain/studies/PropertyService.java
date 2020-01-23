package pl.derilius.demo.domain.studies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.studies.dto.PropertyDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository repository;

    @Autowired
    public PropertyService(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<PropertyDTO> getAll() {
        return repository.findAllByDeletedAtIsNull()
                .stream()
                .map(Mapper::toPropertyDTO)
                .collect(Collectors.toList());
    }


}
