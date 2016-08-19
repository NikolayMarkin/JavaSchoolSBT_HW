package ru.sbt.cacheproxy;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Cache {
    CacheType cacheType() default CacheType.IN_MEMORY;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class[] identityBy() default {};
    int listList() default 100;
}
