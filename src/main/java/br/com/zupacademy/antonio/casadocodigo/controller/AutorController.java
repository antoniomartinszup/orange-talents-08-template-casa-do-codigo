package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import br.com.zupacademy.antonio.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> salvar(@RequestBody @Valid AutorForm autorForm) {
        Autor autorSalvo = autorRepository.save(autorForm.converteParaModelAutor());
        return ResponseEntity.ok().body(AutorDto.converteParaAutorDto(autorSalvo));
    }
}
