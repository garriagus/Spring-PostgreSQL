package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.RFIDKey;

@Repository
public interface RFIDKeyRepository extends JpaRepository<RFIDKey, Long> {
}