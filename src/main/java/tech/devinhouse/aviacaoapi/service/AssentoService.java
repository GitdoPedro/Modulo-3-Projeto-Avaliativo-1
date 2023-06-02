package tech.devinhouse.aviacaoapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.repository.AssentoRepository;

import java.util.List;

@Service
public class AssentoService {

    @Autowired
    AssentoRepository assentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Assento> listarAssentos() {
        List<Assento> assentos;
        assentos = assentoRepository.findAll();

        return assentos;
    }
}
