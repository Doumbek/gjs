package com.gjs.mJunit5.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ArithmeticExceptionLogger implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof ArithmeticException) {
            printMessage(context);
        } else {
            throw throwable;
        }
    }

    private void printMessage(ExtensionContext context) {
        System.out.println(
            String.format(
                "ArithmeticException was thrown for test [%s] from [%s] test class",
                context.getRequiredTestMethod().getName(),
                context.getRequiredTestClass().getName()));
    }
}
