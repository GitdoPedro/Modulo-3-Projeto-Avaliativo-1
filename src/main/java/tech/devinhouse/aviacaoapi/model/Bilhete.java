package tech.devinhouse.aviacaoapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bilhete")
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String eTicket;
    private Boolean malasDespachadas;
    private LocalDateTime dataHoraConfirmacao;
    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;

    @OneToOne
    @JoinColumn(name = "assento_id")
    private Assento assento;

    public Bilhete(Integer id, String eTicket, Boolean malasDespachadas,
                   LocalDateTime dataHoraConfirmacao,
                   Passageiro passageiro, Assento assento) {
        this.id = id;
        this.eTicket = eTicket;
        this.malasDespachadas = malasDespachadas;
        this.dataHoraConfirmacao = dataHoraConfirmacao;
        this.passageiro = passageiro;
        this.assento = assento;
    }
    public Bilhete() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteTicket() {
        return eTicket;
    }

    public void seteTicket(String eTicket) {
        this.eTicket = eTicket;
    }

    public Boolean getMalasDespachadas() {
        return malasDespachadas;
    }

    public void setMalasDespachadas(Boolean malasDespachadas) {
        this.malasDespachadas = malasDespachadas;
    }

    public LocalDateTime getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

    public void setDataHoraConfirmacao(LocalDateTime dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

}
