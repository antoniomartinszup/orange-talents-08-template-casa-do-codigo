package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Pais;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;

import javax.validation.constraints.NotEmpty;

public class PaisForm {

    private Long id;

    @NotEmpty
    @ItemGenericoUnico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais converteParaModelPais() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
