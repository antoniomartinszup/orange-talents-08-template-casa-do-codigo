package br.com.zupacademy.antonio.casadocodigo.controller.form;

import br.com.zupacademy.antonio.casadocodigo.model.*;
import br.com.zupacademy.antonio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.antonio.casadocodigo.validate.AnyCPFOrCNPJ;
import br.com.zupacademy.antonio.casadocodigo.validate.ItemGenericoUnico;
import br.com.zupacademy.antonio.casadocodigo.validate.PaisComEstado;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@PaisComEstado(clienteClass = ClienteForm.class, message = "")
public class ClienteForm {

    @Email
    @ItemGenericoUnico(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    @AnyCPFOrCNPJ
    @ItemGenericoUnico(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotEmpty
    private String endereco;

    @NotEmpty
    private String complemento;

    @NotEmpty
    private String cidade;

    @NotNull
    private Long idPais;
    private Long idEstado;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String cep;

    public ClienteForm(String email, String nome, String sobrenome, String documento,
                       String endereco, String complemento, String cidade, Long idPais,
                       Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente converteParaModelCliente(PaisRepository pRepo, EstadoRepository eRepo) {

        Optional<Pais> pais = pRepo.findById(idPais);
        Optional<Estado> estado = eRepo.findById(idEstado);

        if (!pais.isPresent() || !estado.isPresent()) throw new IllegalArgumentException();
        
        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
                this.complemento, this.cidade, pais.get(), estado.get(), this.telefone, this.cep);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
