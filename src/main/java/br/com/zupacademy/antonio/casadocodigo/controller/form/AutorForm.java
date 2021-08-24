package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import br.com.zupacademy.antonio.casadocodigo.validation.ItemUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @ItemUnico(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

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
