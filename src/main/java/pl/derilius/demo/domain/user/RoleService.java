package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.exception.RoleNotFoundException;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role getRole(Role.Name roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        return role.orElseThrow(RoleNotFoundException::new);
    }

}
