package com.sami.sso;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD , ElementType.METHOD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIdValidation.class)
@Documented
public @interface IdAnnotation {


    String message() default "{com.sami.sso.IdAnnotation.message}";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
