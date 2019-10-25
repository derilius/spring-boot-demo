package pl.derilius.demo.domain.workshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JobRepository extends JpaRepository<Job, Long> {

}
