package com.sami.sso;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;

public class CheckIdValidation implements ConstraintValidator<IdAnnotation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean strFlag = false;
        int result = 12;
        try {
            result = Integer.parseInt(s);
        }catch (Exception e){
            strFlag = true;
        }
        int controlDigit = result % 10;
        int flag;
        result /= 10;
        int sum = 0;
        for (int i = 2; i < 11; i++) {
            sum += result % 10 * i;
            result /= 10;
        }


        if (sum % 11 < 2) {
            flag = sum % 11;
        } else flag = 11 - sum % 11;

        boolean isValid = ((flag == controlDigit)&& !strFlag);
            if (!isValid ) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("{com.sami.sso.constraints.IdAnnotation.message}").addConstraintViolation();
            }
            return (isValid);

    }

    @Override
    public void initialize(IdAnnotation constraintAnnotation) {

    }
}
