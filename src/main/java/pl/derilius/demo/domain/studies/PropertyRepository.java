package pl.derilius.demo.domain.studies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findAllByDeletedAtIsNull();

}
