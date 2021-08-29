package br.com.zupacademy.antonio.casadocodigo.validate;

import br.com.zupacademy.antonio.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.antonio.casadocodigo.model.Estado;
import br.com.zupacademy.antonio.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PaisComEstadoValidation implements ConstraintValidator<PaisComEstado, ClienteForm> {

    @Autowired
    private EstadoRepository estadoRepository;

    private Class<?> clienteClass;

    @Override
    public void initialize(PaisComEstado paisComEstado) {
        clienteClass = paisComEstado.clienteClass();
    }

    @Override
    public boolean isValid(ClienteForm clienteForm, ConstraintValidatorContext constraintValidatorContext) {
        Long idPais = clienteForm.getIdPais();
        Optional<Estado> paisTemEstado = estadoRepository.findByPaisId(idPais);
        return paisTemEstado.isEmpty() || clienteForm.getIdEstado() != null;
    }
}
