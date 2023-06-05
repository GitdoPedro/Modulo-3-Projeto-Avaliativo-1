package tech.devinhouse.aviacaoapi.service;

import org.hibernate.annotations.NotFound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;
import tech.devinhouse.aviacaoapi.dto.PassageiroPorCpfDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PassageiroServiceTest {

    @Mock
    private PassageiroRepository passageiroRepository;

    @InjectMocks
    private PassageiroService passageiroService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("Quando nao ha registros de passageiros, deve retornar uma lista vazia")
    void listarPassageiros_semRegistros() {
        List<Passageiro> passageiros = passageiroService.listarPassageiros();
        assertNotNull(passageiros);
        assertTrue(passageiros.isEmpty());
    }

    @Test
    @DisplayName("Quando há registro de passageiros, deve retornar lista com valores")
    void listarPassageiros_comRegistros(){
        List<Passageiro> passageiros = List.of(
                new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                        LocalDate.of(1990, 5, 15),"VIP",100)
        );
        Mockito.when(passageiroRepository.findAll()).thenReturn(passageiros);
        List<Passageiro> passageiroLista = passageiroService.listarPassageiros();

        assertNotNull(passageiroLista);
        assertFalse(passageiroLista.isEmpty());
        assertEquals(passageiros.size(),passageiroLista.size());
    }

    @Test
    @DisplayName("Quando nao existe passageiro com o cpf informado, deve lancar excecao")
    void consultaPorCPF_naoEncontrado() {
        String cpf = "183.889.250-83";
        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.empty());

        ResponseEntity<String> resultado = passageiroService.consultaPorCPF(cpf);

        assertNotNull(resultado);
        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }



}