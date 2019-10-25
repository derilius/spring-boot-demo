package pl.derilius.demo.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
