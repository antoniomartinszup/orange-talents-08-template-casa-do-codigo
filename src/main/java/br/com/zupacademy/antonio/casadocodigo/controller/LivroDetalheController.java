package br.com.zupacademy.antonio.casadocodigo.controller;

import br.com.zupacademy.antonio.casadocodigo.controller.dto.LivroDtoDetallhe;
import br.com.zupacademy.antonio.casadocodigo.model.Livro;
import br.com.zupacademy.antonio.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livro/{id}")
public class LivroDetalheController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<LivroDtoDetallhe> detalheLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new LivroDtoDetallhe(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
