package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Livro;

public class LivroDtoLista {

    private Long id;
    private String titulo;

    @Deprecated
    public LivroDtoLista() {
    }

    public LivroDtoLista(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public static LivroDtoLista converteParaLivroIdTituloDto(Livro livro) {
        return new LivroDtoLista(livro.getId(), livro.getTitulo());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
