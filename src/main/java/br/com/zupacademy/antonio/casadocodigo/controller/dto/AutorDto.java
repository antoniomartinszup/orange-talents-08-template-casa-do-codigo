package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Autor;

import java.time.LocalDateTime;

public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataRegistro = LocalDateTime.now();

    @Deprecated
    public AutorDto() {
    }

    public AutorDto(Long id, String nome, String email, String descricao, LocalDateTime dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }

    public static AutorDto converteParaAutorDto(Autor autor) {
        return new AutorDto(autor.getId(), autor.getNome(),
                autor.getEmail(), autor.getDescricao(), autor.getDataRegistro());
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
