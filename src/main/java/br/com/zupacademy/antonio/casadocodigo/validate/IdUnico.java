package br.com.zupacademy.antonio.casadocodigo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = IdUnicoValidation.class)
@Target( { FIELD })
@Retention(RUNTIME)
public @interface IdUnico {

    Class<?> domainClass();
    String fieldName();

    String message() default "Id não cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
