package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Pais;

public class PaisDto {

    private Long id;
    private String nome;

    @Deprecated
    public PaisDto() {
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static PaisDto converteParaPaisDto(Pais pais) {
        return new PaisDto(pais.getId(), pais.getNome());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
