package pl.derilius.demo.domain.user;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role getRole() {
        Optional<Role> role = roleRepository.findByName(Role.Name.USER);
        return role.orElseGet(this::createDefaultRole);
    }

    private Role createDefaultRole() {
        List<Permission> permissions = Collections.singletonList(Permission.systemUserRole());
        Role role = new Role(Role.Name.USER, permissions);
        return roleRepository.save(role);
    }

}
