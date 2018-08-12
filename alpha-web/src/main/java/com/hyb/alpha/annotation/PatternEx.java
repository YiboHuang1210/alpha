package com.hyb.alpha.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *  @Pattern注解的扩展
 *
 * length（-1不限制）只匹配长度。
 * isnull指是否可以为空。
 * regexp（为空则不校验）表示同时匹配正则表达式
 *
 * @Author: Huang Yibo
 * @Date: 2018/8/6 23:05
 */
@Documented
@Constraint(validatedBy = {PatternExValidator.class})
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternEx {
    String message() default "内容不一致";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field() default "";
    int[] length() default {};
    boolean isBlank() default false;
    String regexp() default "";
}