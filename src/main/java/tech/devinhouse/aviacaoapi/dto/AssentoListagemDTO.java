package tech.devinhouse.aviacaoapi.dto;

import jakarta.persistence.Column;

public class AssentoListagemDTO {

    private String nome;

    public AssentoListagemDTO() {}

    public AssentoListagemDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
