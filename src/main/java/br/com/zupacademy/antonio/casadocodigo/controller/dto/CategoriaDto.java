package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Categoria;

public class CategoriaDto {

    private Long id;
    private String nome;

    @Deprecated
    public CategoriaDto() {
    }

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaDto converteParaCategoriaDto(Categoria categoria) {
        return new CategoriaDto(categoria.getId(), categoria.getNome());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
