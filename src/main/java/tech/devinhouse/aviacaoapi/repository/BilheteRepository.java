package tech.devinhouse.aviacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.aviacaoapi.model.Bilhete;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Integer> {

}
