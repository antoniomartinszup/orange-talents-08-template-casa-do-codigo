package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Categoria;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @ItemGenericoUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaForm() {
    }

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public Categoria converteParaModelCategoria() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
