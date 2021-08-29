package br.com.zupacademy.antonio.casadocodigo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PaisComEstadoValidation.class)
@Documented
public @interface PaisComEstado {

    String message() default "Este id do pais informado apresenta cadasto de estado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> clienteClass();
}
