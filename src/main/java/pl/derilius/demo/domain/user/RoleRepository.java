package pl.derilius.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Role.Name name);

}
