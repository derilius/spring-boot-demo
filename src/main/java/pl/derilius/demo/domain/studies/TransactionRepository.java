package pl.derilius.demo.domain.studies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByDeletedAtIsNull();

}
