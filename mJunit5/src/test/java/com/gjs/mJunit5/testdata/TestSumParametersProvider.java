package com.gjs.mJunit5.testdata;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TestSumParametersProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
            Arguments.of(2, 4, 6),
            Arguments.of(5, 7, 12),
            Arguments.of(10, -5, 5));
    }
}
