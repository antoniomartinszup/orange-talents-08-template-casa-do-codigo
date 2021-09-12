package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.Estado;
import br.com.zupacademy.antonio.casadocodigo.model.Pais;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antonio.casadocodigo.validate.IdUnico;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoForm {

    @NotEmpty
    @ItemGenericoUnico(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @IdUnico(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @Deprecated
    public EstadoForm() {
    }

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converteParaModelEstado(PaisRepository pRepo) {
        Optional<Pais> pais = pRepo.findById(idPais);
        if (!pais.isPresent()) throw new IllegalArgumentException();
        return new Estado(this.nome, pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
