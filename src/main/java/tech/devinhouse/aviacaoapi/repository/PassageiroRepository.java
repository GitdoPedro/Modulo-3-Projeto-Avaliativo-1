package tech.devinhouse.aviacaoapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.devinhouse.aviacaoapi.model.Passageiro;

import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {
    @Query("SELECT p FROM Passageiro p WHERE p.cpf = :cpf")
    Optional<Passageiro> findByCpf(@Param("cpf") String cpf);

}
