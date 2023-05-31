package tech.devinhouse.aviacaoapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.aviacaoapi.model.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

}
