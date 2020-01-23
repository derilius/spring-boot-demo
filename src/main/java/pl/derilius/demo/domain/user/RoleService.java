package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.studies.Mapper;
import pl.derilius.demo.domain.studies.dto.RoleDTO;
import pl.derilius.demo.exception.RoleNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role getRole(String roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        return role.orElseThrow(RoleNotFoundException::new);
    }

    public List<RoleDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(Mapper::toRoleDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO create(String name) {
        Role role = new Role(name);
        role = roleRepository.save(role);
        return Mapper.toRoleDTO(role);
    }

    public void delete(Long id) {
        Role role = roleRepository.getOne(id);
        roleRepository.delete(role);
    }
}
