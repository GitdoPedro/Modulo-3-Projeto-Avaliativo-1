package tech.devinhouse.aviacaoapi.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class PassageiroPorCpfDTO {
    @Column(unique = true)
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String classificacao;
    private Integer milhas;

    public PassageiroPorCpfDTO(String cpf, String nome, LocalDate dataNascimento,
                               String classificacao, Integer milhas) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.classificacao = classificacao;
        this.milhas = milhas;
    }

    public PassageiroPorCpfDTO() {}

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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        string.append("\"cpf\":\"").append(cpf).append("\",");
        string.append("\"nome\":\"").append(nome).append("\",");
        string.append("\"dataNascimento\":\"").append(dataNascimento).append("\",");
        string.append("\"classificacao\":\"").append(classificacao).append("\",");
        string.append("\"milhas\":").append(milhas);
        string.append("}");
        return string.toString();
    }
}

