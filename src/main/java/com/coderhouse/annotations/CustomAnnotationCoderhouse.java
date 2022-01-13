package com.coderhouse.annotations;

import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotationCoderhouse {
}
