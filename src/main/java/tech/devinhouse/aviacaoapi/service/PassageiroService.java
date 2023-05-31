package tech.devinhouse.aviacaoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacaoapi.mapper.PassageiroMapper;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;

import java.util.List;

@Service
public class PassageiroService {
    @Autowired
    PassageiroMapper PassageiroMapper;
    @Autowired
    PassageiroRepository passageiroRepository;

    public List<Passageiro> listarPassageiros() {
        List<Passageiro> passageiros;
        passageiros = passageiroRepository.findAll();
        return passageiros;

    }

}
