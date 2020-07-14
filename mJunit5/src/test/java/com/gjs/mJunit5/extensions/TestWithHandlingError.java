package com.gjs.mJunit5.extensions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({
    CalculatorParamResolver.class,
    ArithmeticExceptionLogger.class
})
@Test
public @interface TestWithHandlingError {
}
