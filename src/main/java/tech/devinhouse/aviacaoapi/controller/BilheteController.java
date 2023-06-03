package tech.devinhouse.aviacaoapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacaoapi.dto.CheckinRequestDTO;
import tech.devinhouse.aviacaoapi.service.BilheteService;

@RestController
@RequestMapping("/api/passageiros/confirmacao")
public class BilheteController {

    @Autowired
    private BilheteService bilheteService;

    @PostMapping
    public ResponseEntity<String> confirmarBilhete(@RequestBody @Valid CheckinRequestDTO checkinRequestDTO){
        return bilheteService.confirmarBilhete(checkinRequestDTO);
    }

}
