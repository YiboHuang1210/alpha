package com.hyb.alpha.annotation;

import org.apache.commons.lang.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/6 23:07
 * @Description:
 */
public class PatternExValidator implements ConstraintValidator<PatternEx,String> {

    private int[] length;

    private boolean isBlank;

    private String regexp;
    @Override
    public void initialize(PatternEx equalTo) {
        this.length = equalTo.length();
        this.isBlank = equalTo.isBlank();
        this.regexp = equalTo.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(isBlank && StringUtils.isBlank(s)){
            return true;
        }
        if(length != null && length.length > 0){
            boolean sign = true;
            for(int val : length){
                if(s.length() == val){
                    sign = false;
                }
            }
            if(sign){
                return false;
            }
        }

        if(StringUtils.isNotBlank(regexp) && !s.matches(regexp)){
            return false;
        }
        return true;
    }
}