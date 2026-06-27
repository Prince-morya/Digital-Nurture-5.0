# TDD using JUnit5 and Mockito

A single Maven project covering four exercises. Standard Maven layout — production code under `src/main/java`, tests under `src/test/java`.

## Files

```
pom.xml
src/main/java/Calculator.java       -> used by Exercise 4
src/main/java/ExternalApi.java      -> used by Exercises 1 and 2
src/main/java/MyService.java        -> used by Exercises 1 and 2

src/test/java/AssertionsTest.java             -> Exercise 3: Assertions in JUnit
src/test/java/CalculatorTest.java             -> Exercise 4: AAA pattern, setup/teardown
src/test/java/MockingAndStubbingTest.java     -> Exercise 1: Mocking and Stubbing
src/test/java/VerifyingInteractionsTest.java  -> Exercise 2: Verifying Interactions
```

## What each exercise does

**Exercise 3 — Assertions in JUnit:** runs through the core JUnit assertions (`assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`) in a single test method.

**Exercise 4 — AAA Pattern, Setup and Teardown:** `CalculatorTest` arranges input values, acts by calling `Calculator.add`/`subtract`, then asserts the result. `@Before` creates a fresh `Calculator` before each test and `@After` clears it afterward.

A quick note on annotations here: the assignment specifically calls for `@Before`/`@After`, which are JUnit 4 annotations (JUnit 5 renamed them `@BeforeEach`/`@AfterEach`). The `pom.xml` includes the JUnit Vintage engine alongside Jupiter so both styles run correctly side by side in the same project. If your course actually wants pure JUnit 5 here, just swap `@Before`/`@After` for `@BeforeEach`/`@AfterEach` and the imports for `org.junit.jupiter.api.*` — let me know if you'd like that version instead.

**Exercise 1 — Mocking and Stubbing:** creates a mock `ExternalApi`, stubs `getData()` to return `"Mock Data"`, then checks that `MyService.fetchData()` returns it.

**Exercise 2 — Verifying Interactions:** creates a mock `ExternalApi`, calls `MyService.fetchData()`, then verifies `getData()` was actually invoked on the mock.

## Running in VS Code

1. Install the **Extension Pack for Java** (includes Maven and Test Runner support).
2. Open this folder in VS Code.
3. Open the **Testing** tab in the sidebar (flask icon) — it will discover all four test classes automatically.
4. Click the play button next to any test, test class, or "Run All Tests" at the top.

You don't need Maven installed separately for this — the Java extension manages the build and dependencies for you.

## Running from terminal (if Maven is installed)

```powershell
cd "TDD using JUnit5 and Mockito"
mvn test
```

This compiles everything and runs all four test classes, printing a pass/fail summary for each.
