package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.antonio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.antonio.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.antonio.casadocodigo.model.Cliente;
import br.com.zupacademy.antonio.casadocodigo.model.Livro;
import br.com.zupacademy.antonio.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente clienteSalvo = clienteRepository.save(clienteForm.converteParaModelCliente(paisRepository, estadoRepository));
        return ResponseEntity.ok().body(ClienteDto.converteParaClienteDto(clienteSalvo));
    }
}
