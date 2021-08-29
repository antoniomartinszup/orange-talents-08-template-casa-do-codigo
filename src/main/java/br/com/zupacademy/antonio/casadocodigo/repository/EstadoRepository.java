package br.com.zupacademy.antonio.casadocodigo.repository;

import br.com.zupacademy.antonio.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByPaisId(Long idPais);
}
