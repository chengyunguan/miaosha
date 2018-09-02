package org.ucas.cyg.validator;

import org.apache.commons.lang3.StringUtils;
import org.ucas.cyg.util.ValidateUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 16:58
 * @Description:
 */
public class isMobileValidator implements ConstraintValidator<isMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            return ValidateUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidateUtil.isMobile(value);
            }

        }
    }


}
