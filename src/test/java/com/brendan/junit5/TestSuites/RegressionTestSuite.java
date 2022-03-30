package com.brendan.junit5.TestSuites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run only tests tagged with 'regression'.")
@SelectPackages("com.brendan.junit5")
@IncludeTags("regression")
@IncludeClassNamePatterns(".*Tag.*")
public class RegressionTestSuite {
}
