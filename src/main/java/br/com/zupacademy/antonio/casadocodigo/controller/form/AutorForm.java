package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @ItemGenericoUnico(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    @Deprecated
    public AutorForm() {
    }

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converteParaModelAutor() {
        return new Autor(this.nome, this.email, this.descricao);
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
}
