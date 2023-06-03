package tech.devinhouse.aviacaoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacaoapi.dto.CheckinRequestDTO;
import tech.devinhouse.aviacaoapi.dto.ChekinResponseDTO;
import tech.devinhouse.aviacaoapi.helper.SaldoMilhas;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.model.Bilhete;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.AssentoRepository;
import tech.devinhouse.aviacaoapi.repository.BilheteRepository;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;
import java.util.UUID;

@Service
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

        //regra 1
        if(passageiroExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O cpf informado não retornou nenhum passageiro");
        }
        Integer idade = Period.between(
                passageiroExistente.get().getDataNascimento(),
                LocalDate.now()).getYears();
        //regra 2
        if (assentoSelecionado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O assento informado não existe");
        //regra 3
        }else if(assentoSelecionado.getOcupado()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O assento informado não está disponível");
        //regra 4
        }else if(idade<18 && assentoSelecionado.getEmergencial()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Passageiro não pode ser menor de idade para o assento desejado");
        //regra 5
        }else if(checkinRequestDTO.getMalasDespachadas() == false && assentoSelecionado.getEmergencial()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Obrigatório despachar as malas para o assento desejado");
        }else{
            //regra 6
            ChekinResponseDTO checkinResponseDTO = new ChekinResponseDTO(
                    UUID.randomUUID().toString(),LocalDateTime.now()
            );
            //regra 7
            SaldoMilhas novoSaldo = new SaldoMilhas(
                    passageiroExistente.get().getClassificacao(),
                    passageiroExistente.get().getMilhas());

            passageiroExistente.get().setMilhas(novoSaldo.getMilhas());
            passageiroRepository.save(passageiroExistente.get());
            assentoSelecionado.setOcupado(true);

            Bilhete bilheteCadastro = new Bilhete();
            bilheteCadastro.seteTicket(checkinResponseDTO.geteTicket());
            bilheteCadastro.setAssento(assentoSelecionado);
            bilheteCadastro.setPassageiro(passageiroExistente.get());
            bilheteCadastro.setMalasDespachadas(checkinRequestDTO.getMalasDespachadas());
            bilheteCadastro.setDataHoraConfirmacao(checkinResponseDTO.getDataHoraConfirmacao());

            bilheteRepository.save(bilheteCadastro);
            //regra 8
            System.out.println(
                    "Confirmação feita pelo passageiro de CPF "+ checkinRequestDTO.getCpf()+
                    " com e-ticket "+ checkinResponseDTO.geteTicket());
            return ResponseEntity.status(HttpStatus.CREATED).
                    body("eticket:  " + checkinResponseDTO.geteTicket() +
                            "\ndataHotaConfirmacao: " + checkinResponseDTO.getDataHoraConfirmacao());

    }
    }
}
