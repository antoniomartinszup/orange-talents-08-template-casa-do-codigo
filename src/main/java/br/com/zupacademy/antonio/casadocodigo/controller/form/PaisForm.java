package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Pais;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;

import javax.validation.constraints.NotEmpty;

public class PaisForm {

    @NotEmpty
    @ItemGenericoUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisForm() {
    }

    public PaisForm(String nome) {
        this.nome = nome;
    }

    public Pais converteParaModelPais() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
