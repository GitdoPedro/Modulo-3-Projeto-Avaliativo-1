package tech.devinhouse.aviacaoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assentos")
public class Assentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;
    private Boolean emergencial;

    public Assentos(Integer id, String nome, Boolean emergencial) {
        this.id = id;
        this.nome = nome;
        this.emergencial = emergencial;
    }

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
