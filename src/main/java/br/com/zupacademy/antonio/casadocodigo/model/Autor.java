package br.com.zupacademy.antonio.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Column(length = 400)
    private String descricao;
    private LocalDateTime dataRegistro = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
