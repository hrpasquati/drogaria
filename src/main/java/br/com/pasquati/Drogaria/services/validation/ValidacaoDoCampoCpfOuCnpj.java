package br.com.pasquati.Drogaria.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidacaoDoCampoCpfOuCnpjValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidacaoDoCampoCpfOuCnpj {
    String message() default "Error de validação";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] playload() default {};

}
