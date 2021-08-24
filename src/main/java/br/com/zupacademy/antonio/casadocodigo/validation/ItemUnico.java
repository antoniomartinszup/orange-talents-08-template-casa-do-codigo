package br.com.zupacademy.antonio.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ItemUnicoValidation.class)
@Target( { FIELD })
@Retention(RUNTIME)
public @interface ItemUnico {

    Class<?> domainClass();
    String fieldName();

    String message() default "Item já cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
