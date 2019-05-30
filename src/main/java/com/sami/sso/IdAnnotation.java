package com.sami.sso;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIdValidation.class)
@Documented
public @interface IdAnnotation {
    String id() default "{com.sami.sso.constraints.IdAnnotation}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
