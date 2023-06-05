package tech.devinhouse.aviacaoapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.repository.AssentoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AssentoServiceTest {

    @Mock
    private AssentoRepository assentoRepository;

    @InjectMocks
    private AssentoService assentoService;

    @Test
    @DisplayName("Quando nao ha registros de assentos, deve retornar uma lista vazia")
    void listarAssentos_semRegistros() {
        List<Assento> assentos = assentoService.listarAssentos();
        assertNotNull(assentos);
        assertTrue(assentos.isEmpty());
    }

    @Test
    @DisplayName("Quando há registro de assentos, deve retornar lista com valores")
    void listarAssentos_comRegistros(){
        List<Assento> assentos = List.of(
                new Assento(1000,"5A",true),
                new Assento(1001,"4A",false)
        );
        Mockito.when(assentoRepository.findAll()).thenReturn(assentos);
        List<Assento> assentosLista = assentoService.listarAssentos();

        assertNotNull(assentosLista);
        assertFalse(assentosLista.isEmpty());
        assertEquals(assentos.size(),assentosLista.size());
    }


}