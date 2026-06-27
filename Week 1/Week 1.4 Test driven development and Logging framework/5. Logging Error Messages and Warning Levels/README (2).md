# SLF4J Logging Framework

A small Maven project demonstrating error and warning level logging with SLF4J and Logback.

## Files

```
pom.xml
src/main/java/LoggingExample.java       -> Exercise 1: Logging Error Messages and Warning Levels
src/main/resources/logback.xml          -> console output configuration
```

## What it does

`LoggingExample` gets a logger for itself via `LoggerFactory`, then logs one error message and one warning message. `logback.xml` sets the root logging level to `warn`, so both messages print to the console with a timestamp, thread name, and level — info/debug messages would be suppressed at this level, which is intentional for this exercise.

## Running in VS Code

1. Install the **Extension Pack for Java** if you don't already have it.
2. Open this folder in VS Code.
3. Open `LoggingExample.java` and click the **Run** link above `public static void main(String[] args)`.

VS Code resolves the SLF4J and Logback dependencies from `pom.xml` automatically.

## Running from terminal (if Maven is installed)

```powershell
cd "SLF4J logging framework"
mvn compile exec:java
```

## Expected output

```
HH:mm:ss.SSS [main] ERROR LoggingExample - This is an error message
HH:mm:ss.SSS [main] WARN  LoggingExample - This is a warning message
```

(the timestamp will reflect the actual time you run it)
