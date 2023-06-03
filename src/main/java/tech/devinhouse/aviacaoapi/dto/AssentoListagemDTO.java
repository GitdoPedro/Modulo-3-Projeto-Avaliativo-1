package tech.devinhouse.aviacaoapi.dto;

import jakarta.persistence.Column;

public class AssentoListagemDTO {

    private String nome;
    private Boolean ocupado;

    public AssentoListagemDTO(String nome, Boolean ocupado) {
        this.nome = nome;
        this.ocupado = ocupado;
    }

    public AssentoListagemDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}
