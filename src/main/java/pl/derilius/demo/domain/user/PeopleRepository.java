package pl.derilius.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByDeletedAtIsNull();

}
