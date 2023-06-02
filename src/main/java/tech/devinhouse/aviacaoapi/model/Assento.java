package tech.devinhouse.aviacaoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assento")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;
    private Boolean emergencial;
    private Boolean ocupado;

    public Assento(Integer id, String nome, Boolean emergencial,Boolean ocupado) {
        this.id = id;
        this.nome = nome;
        this.emergencial = emergencial;
        this.ocupado = false;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Assento() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getEmergencial() {
        return emergencial;
    }

    public void setEmergencial(Boolean emergencial) {
        this.emergencial = emergencial;
    }
}
