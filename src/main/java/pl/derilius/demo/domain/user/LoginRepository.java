package pl.derilius.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByMail(String mail);

    Optional<Login> findByActivateToken(String token);

    Optional<Login> findByPasswordToken(String token);

}
