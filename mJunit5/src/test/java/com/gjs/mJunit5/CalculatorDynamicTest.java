package com.gjs.mJunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class CalculatorDynamicTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        System.out.println("@BeforeEach");
        calculator = new Calculator();
    }

    @TestFactory
    public Collection<DynamicTest> testDynamicallyUsingCollection() {
        return Arrays.asList(
            DynamicTest.dynamicTest(
                "First dynamic test",
                () -> assertEquals(4, calculator.sum(1,3))),
            DynamicTest.dynamicTest(
                "Second dynamic test",
                () -> assertEquals(20, calculator.multiply(4,5))));
    }
}
