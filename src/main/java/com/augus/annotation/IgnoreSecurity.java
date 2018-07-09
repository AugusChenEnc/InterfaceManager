package com.augus.annotation;

import java.lang.annotation.*;

/**
 * @author Augus
 * @date 2018/7/9 14:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {

}
