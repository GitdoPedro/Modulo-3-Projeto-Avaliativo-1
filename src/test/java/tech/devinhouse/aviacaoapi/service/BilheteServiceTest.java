package tech.devinhouse.aviacaoapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.devinhouse.aviacaoapi.dto.CheckinRequestDTO;
import tech.devinhouse.aviacaoapi.model.Assento;
import tech.devinhouse.aviacaoapi.model.Passageiro;
import tech.devinhouse.aviacaoapi.repository.AssentoRepository;
import tech.devinhouse.aviacaoapi.repository.BilheteRepository;
import tech.devinhouse.aviacaoapi.repository.PassageiroRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BilheteServiceTest {

    @Mock
    private PassageiroRepository passageiroRepository;
    @Mock
    private BilheteRepository bilheteRepository;
    @Mock
    private AssentoRepository assentoRepository;
    @InjectMocks
    private PassageiroService passageiroService;
    @InjectMocks
    private BilheteService bilheteService;
    @InjectMocks
    private AssentoService assentoService;


    @Test //Regra 1
    @DisplayName("Quando o passageiro não existe, deve retornar status NOT_FOUND")
    void confirmarBilhete_passageiroNaoEncontrado() {

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00", "5A",true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);


        assertNotNull(resultado);
        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
        assertEquals("O cpf informado não retornou nenhum passageiro", resultado.getBody());
    }



    @Test //Regra 2
    @DisplayName("Quando o assento informado não existe, deve retornar status NOT_FOUND")
    void confirmarBilhete_assentoInexistente() {
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
        assertEquals("O assento informado não existe", resultado.getBody());
    }

    @Test //Regra 3
    @DisplayName("Quando o assento informado está ocupado, deve retornar status CONFLICT")
    void confirmarBilhete_assentoOcupado(){
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"1A",false);
        assento.setOcupado(true);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.CONFLICT, resultado.getStatusCode());
        assertEquals("O assento informado não está disponível", resultado.getBody());
    }

    @Test //Regra 4
    @DisplayName("Quando o assento informado está ocupado, deve retornar status CONFLICT")
    void confirmarBilhete_passageiroMenorIdade(){
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(2015, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"5A",true);
        assento.setOcupado(false);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.BAD_REQUEST, resultado.getStatusCode());
        assertEquals("Passageiro não pode ser menor de idade para o assento desejado", resultado.getBody());
    }

    @Test //Regra 5
    @DisplayName("Quando o assento informado está ocupado, deve retornar status CONFLICT")
    void confirmarBilhete_obrigatorioDespacharMalas(){
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"5A",true);
        assento.setOcupado(false);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", false);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.BAD_REQUEST, resultado.getStatusCode());
        assertEquals("Obrigatório despachar as malas para o assento desejado", resultado.getBody());
    }
    @Test //Regra 6
    @DisplayName("Respeitando as regras anteriores, cadastro é efetuado")
    void confirmarBilhete_cadastroSucesso(){
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"5A",true);
        assento.setOcupado(false);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());

    }

    @Test //Regra 7
    @DisplayName("Após cadastro, número de milhas é atualizado")
    void confirmarBilhete_atualizaPontos(){
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"5A",true);
        assento.setOcupado(false);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);

        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
        assertEquals(200, passageiro.getMilhas());
    }

    @Test //regra 8
    @DisplayName("Teste de saída no System.out.println")
    void testeSystemOut() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        Passageiro passageiro = new Passageiro(1000,"000.000.000-00","Pedro Lima do Nascimento",
                LocalDate.of(1990, 5, 15),"VIP",100);
        Assento assento = new Assento(000,"5A",true);
        assento.setOcupado(false);

        Mockito.when(passageiroRepository.findByCpf(Mockito.anyString()))
                .thenReturn(Optional.of(passageiro));
        Mockito.when(assentoRepository.findByNomeIgnoreCase(Mockito.anyString()))
                .thenReturn(assento);

        CheckinRequestDTO checkinRequestDTO = new CheckinRequestDTO(
                "000.000.000-00","5A", true);

        try {

            System.setOut(printStream);
            ResponseEntity<String> resultado = bilheteService.confirmarBilhete(checkinRequestDTO);
            String output = outputStream.toString().trim();
            assertTrue(output.contains("Confirmação feita pelo passageiro de CPF 000.000.000-00 com e-ticket"));
        } finally {
            System.setOut(originalPrintStream);
        }
    }






}