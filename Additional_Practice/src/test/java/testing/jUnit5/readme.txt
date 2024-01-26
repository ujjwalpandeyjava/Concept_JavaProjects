JUnit 5:

1. Purpose:
   - JUnit 5 testing framework

2. Modules: 3 main modules: JUnit Platform, JUnit Jupiter, and JUnit Vintage.
   -- JUnit Vintage: Allows backward compatibility (JUnit 3 and JUnit 4)
   -- JUnit Jupiter: Programming model for writing tests and extensions (New annotations & back code)
   -- JUnit Platform: Launching framework for running tests on the JVM (jUnit starts here)

3. Annotations:
   - JUnit 5 introduces new annotations for writing tests, such as `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`, etc.

4. Assertions:
   - Assertions have been revamped with the `assertAll` and `assertThrows` methods, providing more flexibility and better reporting.

5. Parameterized Tests:
   - JUnit 5 supports parameterized tests with the `@ParameterizedTest` annotation, allowing you to run the same test with different inputs.

6. Extensions:
   - Extensions are a powerful feature in JUnit 5, providing additional functionality to tests via annotations or interfaces.

7. Conditional Test Execution:
   - You can control test execution based on certain conditions using the `@Enabled*` and `@Disabled*` annotations.

8. Dynamic Tests:
   - JUnit 5 allows the creation of dynamic tests at runtime using the `TestFactory` and `DynamicTest` API.

9. IDE Support:
   - JUnit 5 is supported by modern IDEs like Eclipse, IntelliJ IDEA, and others.

10. Gradle and Maven Support:
    - JUnit 5 can be easily integrated into both Gradle and Maven build systems.

JUnit 5 provides a more flexible and modern testing framework compared to its predecessors, making it a preferred choice for Java developers. If you have specific questions or need more details on any aspect, feel free to ask.





@Nested: for inner class
@TestFactory: 