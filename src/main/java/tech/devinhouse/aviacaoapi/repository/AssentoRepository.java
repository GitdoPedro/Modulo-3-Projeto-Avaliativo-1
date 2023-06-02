package tech.devinhouse.aviacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.aviacaoapi.model.Assento;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, String>{
    Assento findByNomeIgnoreCase(String nomeAssento);
}
