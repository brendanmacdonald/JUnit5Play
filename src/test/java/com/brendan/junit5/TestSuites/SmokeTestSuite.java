package com.brendan.junit5.TestSuites;

import com.brendan.junit5.TagTests;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only tests tagged with 'smoke'.")
@SelectClasses(TagTests.class)
@IncludeTags("smoke")
public class SmokeTestSuite
{
}