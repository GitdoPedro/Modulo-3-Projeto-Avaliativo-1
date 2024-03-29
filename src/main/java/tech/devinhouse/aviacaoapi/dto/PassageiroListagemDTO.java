package tech.devinhouse.aviacaoapi.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PassageiroListagemDTO {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String classificacao;
    private Integer milhas;
    private String eticket;
    private String assento;
    private LocalDateTime dataHora;

    public PassageiroListagemDTO(String cpf, String nome, LocalDate dataNascimento,
                                 String classificacao, Integer milhas) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.classificacao = classificacao;
        this.milhas = milhas;
        this.eticket = null;
        this.assento = null;
        this.dataHora = null;
    }

    public PassageiroListagemDTO() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getMilhas() {
        return milhas;
    }

    public void setMilhas(Integer milhas) {
        this.milhas = milhas;
    }

    public String getEticket() {
        return eticket;
    }

    public void setEticket(String eticket) {
        this.eticket = eticket;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
