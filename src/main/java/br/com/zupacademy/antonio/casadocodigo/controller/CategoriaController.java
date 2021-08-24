package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.antonio.casadocodigo.model.Categoria;
import br.com.zupacademy.antonio.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> salvar(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoriaSalvo = categoriaRepository.save(categoriaForm.converteParaModelCategoria());
        return ResponseEntity.ok().body(CategoriaDto.converteParaCategoriaDto(categoriaSalvo));
    }
}
