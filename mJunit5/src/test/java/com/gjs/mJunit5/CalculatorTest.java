package com.gjs.mJunit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.RepeatedTest.CURRENT_REPETITION_PLACEHOLDER;
import static org.junit.jupiter.api.RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Verify that Calculator")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void initAll() {
    }

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Nested()
    @DisplayName("should correctly")
    class NestedTests {

        @Test
        @DisplayName("sum")
        public void shouldSum() {
            assertAll("Something went wrong",
                () -> assertEquals(calculator.sum(2, 2), 4),
                () -> assertEquals(calculator.sum(0, 2), 2));
        }

        @Test
        @DisplayName("subtract")
        // @Disabled("Some reason for disabling")
        public void shouldSubtract() {
            assertEquals(calculator.subtract(5, 2), 3,
                () -> String.format("Should be %d - %d = %d", 5, 2, 3));
        }

        @Test
        @Tag("multiply")
        @DisplayName("multiply")
        public void shouldMultiply() {
            assertEquals(calculator.multiply(5, 2), 10,
                () -> String.format("Should be %d * %d = %d", 5, 2, 10));
        }

        @Test
        @Tag("divide")
        @DisplayName("divide")
        public void shouldDivide() {
            assertEquals(calculator.divide(8, 4), 2,
                () -> String.format("Should be %d / %d = %d", 8, 4, 2));
        }
    }

    @RepeatedTest(value = 2, name = CURRENT_REPETITION_PLACEHOLDER + " of " + TOTAL_REPETITIONS_PLACEHOLDER)
    @Tags({
        @Tag("exception"),
        @Tag("divide")
    })
    @DisplayName("should throw Arithmetic exception when divided by 0")
    public void shouldThrowExceptionIfDivideBy0() {
        final Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
