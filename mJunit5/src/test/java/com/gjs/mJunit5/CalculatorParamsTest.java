package com.gjs.mJunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.gjs.mJunit5.testdata.TestSumParametersProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParamsTest {

    private static final int SECONDS_IN_A_MINUTE = 60;

    private Calculator calculator;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.out.println("@BeforeEach: " + testInfo.getDisplayName());
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "Test #{index}: multiplier={0}")
    @ValueSource(ints = { 1, 3, 4 })
    @DisplayName("should use value source")
    public void shouldUseValueSource(final int multiplier) {
        assertEquals(Math.pow(multiplier, 2), calculator.multiply(multiplier, multiplier));
    }

    @ParameterizedTest(name = "Test #{index}: multiplier={0}")
    @MethodSource("getOneParam")
    @DisplayName("should use method source with 1 param")
    public void shouldUseMethodSourceOneParam(final int multiplier) {
        assertEquals(Math.pow(multiplier, 2), calculator.multiply(multiplier, multiplier));
    }

    @ParameterizedTest(name = "Test #{index}: number={0}, result={1}")
    @MethodSource("getTwoParams")
    @DisplayName("should use method source with 2 param")
    public void shouldUseMethodSourceTwoParams(final int number, final int result) {
        assertEquals(result, calculator.multiply(number, 2));
    }

    @ParameterizedTest(name = "Test #{index}: timeunit={0}")
    @EnumSource(value = TimeUnit.class, names = "^SEC.*", mode = EnumSource.Mode.MATCH_ALL)
    @DisplayName("should use enum source")
    public void shouldUseEnumSource(final TimeUnit timeUnit) {
        assertEquals(timeUnit.toMinutes(120), calculator.divide(120, SECONDS_IN_A_MINUTE));
    }

    @ParameterizedTest(name = "Test #{index}: firstNumber={0}, secondNumber={1}, result={2}")
    @CsvFileSource(resources = "/getTestSumData.csv")
    @DisplayName("should use csv file source")
    public void shouldUseCsvFileSource(final int firstNumber, final int secondNumber, final int result) {
        assertEquals(result, calculator.sum(firstNumber, secondNumber));
    }

    @ParameterizedTest(name = "Test #{index}: firstNumber={0}, secondNumber={1}, result={2}")
    @ArgumentsSource(TestSumParametersProvider.class)
    @DisplayName("should use arguments provider source")
    public void shouldUseArgumentsProviderSource(final int firstNumber, final int secondNumber, final int result) {
        assertEquals(result, calculator.sum(firstNumber, secondNumber));
    }

    private static IntStream getOneParam() {
        return IntStream.range(1, 6);
    }

    private static Stream<Arguments> getTwoParams() {
        return Stream.of(1, 5)
            .map(value -> Arguments.of(value, value * 2));
    }
}
