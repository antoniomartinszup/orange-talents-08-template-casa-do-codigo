package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.EstadoDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.antonio.casadocodigo.model.Estado;;
import br.com.zupacademy.antonio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDto> salvar(@RequestBody @Valid EstadoForm estadoForm) {
        Estado estadoSalvo = estadoRepository.save(estadoForm.converteParaModelEstado(paisRepository));
        return ResponseEntity.ok().body(EstadoDto.converteParaEstadoDto(estadoSalvo));
    }
}
