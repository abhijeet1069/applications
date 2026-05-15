# JUnit Core

** Tests should act as a specification of the system’s behavior.**

A good test suite should cover:
- Simple cases
- Common cases
- Error cases
- Boundary cases

## Assertions

Assertions are methods used to verify expected behavior in tests.
Below are common assertions.

### Equality

```java
assertEquals(expected, actual);
assertNotEquals(expected, actual);

assertEquals(4, 2 + 2);
```
### Boolean conditions

```java
assertTrue(condition); 
assertFalse(condition);

assertTrue(LeapYear.isLeap(2024));
```

### Null Checks

```java
assertNull(obj); 
assertNotNull(obj);
```

### Object Identity

```java
assertSame(obj1, obj2); // same reference 
assertNotSame(obj1, obj2);
```
### Exception Testing

```java
assertThrows(Exception.class, () -> {
    methodCall();
});

assertThrows(IllegalArgumentException.class, () -> {
    divide(10, 0);
});
```
### Timeout

```java
assertTimeout(Duration.ofMillis(100), () -> { 
    methodCall(); 
});
```

### Grouped Asssertions

```java
//runs all assertions, reports all failures together
assertAll( 
        () -> assertEquals(2, 1 + 1), 
        () -> assertTrue(true) 
);
```

## Assumptions

Assumptions are used to conditionally run tests.
If an assumption fails → test is skipped (aborted), not failed.

Used when
- OS-specific tests
- DB availability 
- environment variables

### assumeTrue

```java
assumeTrue(condition);

assumeTrue(System.getProperty("os.name").contains("Linux"));

```

### assumeFalse

```java
assumeFalse(condition);

assumeFalse(isProductionEnvironment());
```

### assumingThat

Unlike assumeTrue, this does NOT abort the test—just skips the block

```java
assumingThat(condition, () -> {
    // code runs only if condition is true
});

assumingThat(
    "DEV".equals(System.getenv("ENV")),
    () -> System.out.println("Running DEV-specific checks")
);

```

## Nested tests

Nested tests allow you to group related test cases inside inner classes to organize tests hierarchically.

See leap year example, its a beautiful nested test example.

## Parameterized Tests

A parametrized tests lets you run the same test method multiple times with different inputs.

- ValueSource : Simple values string, int etc
- CsvSource : Multiple parameters, if too much csv values we can separate data to a separate CSV file
                with CsvFileSource
- MethodSource : Custom complex data

## Tagged Tests

Tagged tests allow you to categorize and selectively run tests.
You mark tests with tags and then include/exclude them during execution.

```java
import org.junit.jupiter.api.Tag; 
import org.junit.jupiter.api.Test; 

class TaggedTestExample { 
    @Test 
    @Tag("fast") 
    void fastTest() { 
        System.out.println("Fast test running"); 
    } 
    @Test @Tag("slow") 
    void slowTest() { 
        System.out.println("Slow test running"); 
    } 
}
```

```shell
Run only "fast" tests:
    mvn test -Dgroups=fast

Exclude "slow" tests:
    mvn test -DexcludedGroups=slow
```

## Dependency Injection

JUnit DI (ParameterResolver) is a low level extension mechanism mainly for framework authors and library devs.
Not every day for app developers.