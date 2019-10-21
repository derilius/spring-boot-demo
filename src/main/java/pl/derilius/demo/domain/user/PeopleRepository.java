package pl.derilius.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PeopleRepository extends JpaRepository<People, Long> {

}
