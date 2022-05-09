# Requirements to run the tests located in /src/test/
1. Download, install, and configure Java
   1. https://www.oracle.com/java/technologies/downloads/#jdk17-windows
   2. Add **JAVA_HOME** to the User Variables in Environment Variables and set the path to the location of the java install.
   3. Add **%JAVA_HOME%\bin** the **Path** variable in the System Variables.
2. Download, install, and configure Maven 
   1. https://maven.apache.org/download.cgi
   2. Extract the downloaded zip file (e.g. to C:\Program Files\Maven\apache-maven-3.8.5)
   3. Add **MAVEN_HOME** to the System Variables in Environment Variables and set the path to C:\Program Files\Maven\apache-maven-3.8.5.
   4. Add **%MAVEN_HOME%\bin** to the **Path** variable in the System Variables.

# Running @Tag tests
   There are three approaches.
## Approach 1
Specify on the command line which @Tags to execute or not:
   * `mvn clean test -Dgroups="smoke, development"`
   * `mvn clean test -DexcludedGroups="regression"`
## Approach 2
Set the `<configuration>` tag in the maven-surefire-plugin like this:\
   `<!-- include @Tag -->`\
   `<groups>smoke, regression</groups>`\
   `<!-- exclude @Tag -->`\
   `<excludedGroups>development</excludedGroups>`\

This command can then be used to run only 'included' tags from the TagTests class:\
     * ` mvn clean test -Dtest="TagTests"`\

This command can be used to run only 'included' tags across all .*Test classes:\
` mvn clean test -Dtest=".*Tests"`
## Approach 3 
Create a custom test suite and annotate as required. See 'TestSuites' folder for examples.\
Set the `<configuration>` tag in the maven-surefire-plugin like this:\
`<includes>`\
`<include>**/DevelopmentTestSuite</include>`\
`</includes>`\

This command can be used to execute a test suite:\
`mvn clean test`\
or something less specific like this\
`<includes>`\
`<include>${testSuite}</include>`\
`</includes>`\

This command can be used to execute a test suite:\
`mvn clean test -DtestSuite="**/DevelopmentTestSuite"`\

Test Suites require both of the following maven dependencies:
* junit-platform-suite-api
* junit-platform-suite-engine

_WIP - TO DO_:
1. _Parallel_
2. _ArgumentsProvider_
3. _RegisterExtension_
4. _TestFactory_