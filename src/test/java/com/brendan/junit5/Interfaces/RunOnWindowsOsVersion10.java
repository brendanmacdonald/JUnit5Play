package com.brendan.junit5.Interfaces;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Test
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EnabledOnOs(OS.WINDOWS)
@EnabledIfSystemProperty(named = "os.version", matches = ".*10.0.*")
public @interface RunOnWindowsOsVersion10 {
    // This is a custom condition used in the ConditionalTests class.
}
