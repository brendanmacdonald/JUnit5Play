package com.brendan.junit5.Extensions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class LoggingExtension implements BeforeTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        Method testMethod = extensionContext.getRequiredTestMethod();
        String param = extensionContext.getDisplayName();
        logger.info(() -> String.format("Starting test [%s] with parameter [%s].", testMethod.getName(), param));
    }
}
