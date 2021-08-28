package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.PaisForm;
import br.com.zupacademy.antonio.casadocodigo.model.Pais;
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
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDto> salvar(@RequestBody @Valid PaisForm paisForm) {
        Pais paisSalvo = paisRepository.save(paisForm.converteParaModelPais());
        return ResponseEntity.ok().body(PaisDto.converteParaPaisDto(paisSalvo));
    }
}
