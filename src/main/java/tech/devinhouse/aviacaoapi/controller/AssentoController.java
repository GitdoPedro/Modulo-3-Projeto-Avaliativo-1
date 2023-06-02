package tech.devinhouse.aviacaoapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacaoapi.dto.AssentoListagemDTO;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.service.AssentoService;

import java.util.List;

@RestController
@RequestMapping("/api/assentos")
public class AssentoController {
    @Autowired
    private AssentoService assentoService;

    @Autowired
    private ModelMapper modelMapper;

    //4.Consulta de Assentos:
    @GetMapping
    public ResponseEntity<List<AssentoListagemDTO>> listarAssentos() {
        List<Assento> assentos = assentoService.listarAssentos();
        List<AssentoListagemDTO> assentoListagemDTO = assentos.stream()
                .map(p -> modelMapper.map(p, AssentoListagemDTO.class)).toList();
        return ResponseEntity.ok(assentoListagemDTO);
    }


}
