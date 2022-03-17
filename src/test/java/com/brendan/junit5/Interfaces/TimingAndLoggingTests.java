package com.brendan.junit5.Interfaces;

import com.brendan.junit5.Extensions.LoggingExtension;
import com.brendan.junit5.Extensions.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({TimingExtension.class, LoggingExtension.class})
@Target({ElementType.METHOD})
public @interface TimingAndLoggingTests {}