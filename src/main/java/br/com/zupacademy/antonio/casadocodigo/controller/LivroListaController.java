package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.LivroDtoLista;
import br.com.zupacademy.antonio.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro/lista")
public class LivroListaController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroDtoLista>> listaLivro() {
        return ResponseEntity.ok().body(livroRepository.findAll().stream()
                .map(livro -> LivroDtoLista.converteParaLivroIdTituloDto(livro))
                .collect(Collectors.toList()));
    }
}
