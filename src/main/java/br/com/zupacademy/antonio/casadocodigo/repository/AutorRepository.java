package br.com.zupacademy.antonio.casadocodigo.repository;

import br.com.zupacademy.antonio.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
