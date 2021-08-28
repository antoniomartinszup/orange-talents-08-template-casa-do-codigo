package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Estado;
import br.com.zupacademy.antonio.casadocodigo.model.Pais;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antonio.casadocodigo.validate.IdUnico;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    private Long id;

    @NotEmpty
    @ItemGenericoUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @IdUnico(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public Estado converteParaModelEstado(PaisRepository pRepo) {
        Pais pais = pRepo.findById(idPais).get();
        return new Estado(this.nome, pais);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
