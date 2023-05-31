package tech.devinhouse.aviacaoapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String classificacao;
    private Integer milhas;

    public Passageiro(Integer id, String cpf,
                      String nome, LocalDate dataNascimento,
                      String classificacao, Integer milhas) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.classificacao = classificacao;
        this.milhas = milhas;
    }

    public Passageiro() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
