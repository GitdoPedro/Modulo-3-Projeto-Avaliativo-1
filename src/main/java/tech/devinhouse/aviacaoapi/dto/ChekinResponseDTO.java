package tech.devinhouse.aviacaoapi.dto;

import java.time.LocalDateTime;

public class ChekinResponseDTO {
    private String eTicket;
    private LocalDateTime dataHoraConfirmacao;

    public ChekinResponseDTO(String eTicket, LocalDateTime dataHoraConfirmacao) {
        this.eTicket = eTicket;
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

    public ChekinResponseDTO() {}

    public String geteTicket() {
        return eTicket;
    }

    public void seteTicket(String eTicket) {
        this.eTicket = eTicket;
    }

    public LocalDateTime getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

    public void setDataHoraConfirmacao(LocalDateTime dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }
}
