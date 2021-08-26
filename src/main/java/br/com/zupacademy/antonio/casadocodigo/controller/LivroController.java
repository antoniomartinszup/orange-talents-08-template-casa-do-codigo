package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.antonio.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.antonio.casadocodigo.model.Livro;
import br.com.zupacademy.antonio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.antonio.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm) {
        Livro livroSalvo = livroRepository.save(livroForm.converteParaModelLivro(autorRepository, categoriaRepository));
        return ResponseEntity.ok().body(LivroDto.converteParaLivroDto(livroSalvo));
    }
}
