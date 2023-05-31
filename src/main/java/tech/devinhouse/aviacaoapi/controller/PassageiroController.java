package tech.devinhouse.aviacaoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.service.PassageiroService;

import java.util.List;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passaseiroService;

    // 2. Consulta de Dados completos de Passageiros:
    @GetMapping
    public ResponseEntity<List<Passageiro>> listarPassageiros() {
        List<Passageiro> passageiros = passaseiroService.listarPassageiros();
        return ResponseEntity.ok(passageiros);
    }

}
