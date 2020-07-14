package com.gjs.mJunit5;

import com.gjs.mJunit5.extensions.CalculatorParamResolver;
import com.gjs.mJunit5.extensions.LifecycleExtension;
import com.gjs.mJunit5.extensions.TestWithHandlingError;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//@ExtendWith(LifecycleExtension.class)
public class CalculatorExtensionTest {

    @BeforeAll
    public static void initAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach");
    }

    @ExtendWith(LifecycleExtension.class)
    @Test
    public void firstTest() {
        System.out.println("firstTest");
    }

    @ExtendWith(CalculatorParamResolver.class)
    @Test
    public void secondTest(final Calculator calculator) {
        System.out.println("secondTest");
        System.out.println("2+4=" + calculator.sum(2,4));
    }

    @TestWithHandlingError
    public void shouldThrowExceptionIfDivideBy0(final Calculator calculator) {
        calculator.divide(5, 0);
//        throw new IllegalArgumentException("asdasd");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("@AfterAll");
    }
}
