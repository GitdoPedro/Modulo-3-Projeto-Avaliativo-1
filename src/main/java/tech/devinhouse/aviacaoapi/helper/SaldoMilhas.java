package tech.devinhouse.aviacaoapi.helper;

public class SaldoMilhas {
    private String nome;
    private Integer milhas;

    public SaldoMilhas(String nome, Integer milhas) {
        this.nome = nome;
        switch (nome){
            case "VIP":
                this.milhas = milhas+100;
                break;
            case "OURO":
                this.milhas = milhas+80;
                break;
            case "PRATA":
                this.milhas = milhas+50;
                break;
            case "BRONZE":
                this.milhas = milhas+30;
                break;
            case "ASSOCIADO ":
                this.milhas = milhas+10;
                break;
            default:
                this.milhas = milhas;
        }

    }

    public Integer getMilhas() {
        return milhas;
    }
}
