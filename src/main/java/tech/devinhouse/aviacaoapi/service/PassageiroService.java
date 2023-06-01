package tech.devinhouse.aviacaoapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Null;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import tech.devinhouse.aviacaoapi.dto.PassageiroListagemDTO;
import tech.devinhouse.aviacaoapi.dto.PassageiroPorCpfDTO;
import tech.devinhouse.aviacaoapi.mapper.PassageiroMapper;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {


    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Passageiro> listarPassageiros() {
        List<Passageiro> passageiros;
        passageiros = passageiroRepository.findAll();

        return passageiros;

    }

    public ResponseEntity<String> consultaPorCPF(String cpf) {

        Optional<Passageiro> passageiroEncontrado = passageiroRepository.findByCpf(cpf);
        if (passageiroEncontrado.isPresent()) {
            PassageiroPorCpfDTO passageiroPorCpfDTO;
            passageiroPorCpfDTO = modelMapper.map(passageiroEncontrado, PassageiroPorCpfDTO.class);
            return ResponseEntity.status(HttpStatus.OK).body(
                    passageiroPorCpfDTO.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cpf não retornou nenhum cadastro");
        }
    }



}
