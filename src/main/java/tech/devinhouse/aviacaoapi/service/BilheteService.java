package tech.devinhouse.aviacaoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.devinhouse.aviacaoapi.dto.CheckinRequestDTO;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.AssentoRepository;
import tech.devinhouse.aviacaoapi.repository.BilheteRepository;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class BilheteService {
    @Autowired
    BilheteRepository bilheteRepository;
    @Autowired
    AssentoRepository assentoRepository;
    @Autowired
    PassageiroRepository passageiroRepository;

    public ResponseEntity<String> confirmarBilhete(CheckinRequestDTO checkinRequestDTO) {

        Optional<Passageiro> passageiroExistente = passageiroRepository.findByCpf(checkinRequestDTO.getCpf());
        Assento assentoSelecionado = assentoRepository.findByNomeIgnoreCase(
                checkinRequestDTO.getNomeAssento().toUpperCase());


        if(passageiroExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O cpf informado não retornou nenhum passageiro");
        }
        Integer idade = Period.between(
                passageiroExistente.get().getDataNascimento(),
                LocalDate.now()).getYears();

        if (assentoSelecionado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O assento informado não existe");
        }else if(assentoSelecionado.getOcupado()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O assento informado não está disponível");
        }else if(idade<18 && assentoSelecionado.getEmergencial()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Passageiro não pode ser menor de idade para o assento desejado");
        }else if(checkinRequestDTO.getMalasDespachadas() == false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Obrigatório despachar as malas para o assento desejado");
        }else{

        }
    }
}
