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
    private String assento;
    private Boolean malasDespachadas;
    private LocalDateTime dataHoraConfirmacao;

    public Bilhete(Integer id, String eTicket, String assento,
                   Boolean malasDespachadas, LocalDateTime dataHoraConfirmacao) {
        this.id = id;
        this.eTicket = eTicket;
        this.assento = assento;
        this.malasDespachadas = malasDespachadas;
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

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

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
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
}
