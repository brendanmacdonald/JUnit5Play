package com.brendan.junit5.TestSuites;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Run all tests not tagged with 'smoke' or 'regression'.")
@SelectPackages("com.brendan.junit5")
@ExcludeTags({"smoke", "regression"})
@IncludeClassNamePatterns(".*Tag.*")
public class DevelopmentTestSuite {
}
