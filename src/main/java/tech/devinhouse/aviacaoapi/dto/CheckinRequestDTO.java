package tech.devinhouse.aviacaoapi.dto;

import jakarta.validation.constraints.NotNull;

public class CheckinRequestDTO {

    @NotNull(message = "O campo cpf é obrigatório")
    private String cpf;
    @NotNull(message = "O campo assento é obrigatório")
    private String nomeAssento;
    @NotNull(message = "O campo malas despachadas é obrigatório")
    private Boolean malasDespachadas;

    public CheckinRequestDTO(String cpf, String nomeAssento, Boolean malasDespachadas) {
        this.cpf = cpf;
        this.nomeAssento = nomeAssento;
        this.malasDespachadas = malasDespachadas;
    }

    public CheckinRequestDTO() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeAssento() {
        return nomeAssento;
    }

    public void setNomeAssento(String nomeAssento) {
        this.nomeAssento = nomeAssento;
    }

    public Boolean getMalasDespachadas() {
        return malasDespachadas;
    }

    public void setMalasDespachadas(Boolean malasDespachadas) {
        this.malasDespachadas = malasDespachadas;
    }
}
