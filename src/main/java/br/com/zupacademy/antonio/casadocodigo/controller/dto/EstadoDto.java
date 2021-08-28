package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Estado;

public class EstadoDto {

    private Long id;
    private String nome;

    public EstadoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static EstadoDto converteParaEstadoDto(Estado estado) {
        return new EstadoDto(estado.getId(), estado.getNome());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
