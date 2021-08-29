package br.com.zupacademy.antonio.casadocodigo.controller.dto;

import br.com.zupacademy.antonio.casadocodigo.model.Cliente;

public class ClienteDto {

    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Long idPais;
    private Long idEstado;
    private String telefone;
    private String cep;

    public ClienteDto(Long id, String email, String nome, String sobrenome, String documento, String endereco,
                      String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.id = id;
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

    public static ClienteDto converteParaClienteDto(Cliente cliente) {
        return new ClienteDto(cliente.getId(), cliente.getEmail(), cliente.getNome(), cliente.getSobrenome(), cliente.getDocumento(),
                cliente.getEndereco(), cliente.getComplemento(), cliente.getCidade(), (cliente.getPais().getId()), (cliente.getEstado().getId()),
                cliente.getTelefone(), cliente.getCep());
    }

    public Long getId() {
        return id;
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
