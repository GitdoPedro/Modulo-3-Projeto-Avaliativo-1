package tech.devinhouse.aviacaoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacaoapi.dto.PassageiroListagemDTO;
import tech.devinhouse.aviacaoapi.dto.PassageiroPorCpfDTO;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.service.PassageiroService;
import org.modelmapper.ModelMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passaseiroService;
    @Autowired
    private ModelMapper modelMapper;

    // 2. Consulta de Dados completos de Passageiros:
    @GetMapping
    public ResponseEntity<List<PassageiroListagemDTO>> listarPassageiros() {
        List<Passageiro> passageiros = passaseiroService.listarPassageiros();
        List<PassageiroListagemDTO> passageirosDTO = passageiros.stream()
                .map(p -> modelMapper.map(p, PassageiroListagemDTO.class)).toList();
        return ResponseEntity.ok(passageirosDTO);
    }


    //3. Consulta de Passageiro por CPF:
    @GetMapping("/{cpf}")
    public ResponseEntity<String> PassageirosPorCpf(@PathVariable String cpf) {
        return passaseiroService.consultaPorCPF(cpf);
    }
}
