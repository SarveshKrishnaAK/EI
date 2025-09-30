# Singleton Pattern

## Overview
The Singleton Pattern ensures a class has only one instance and provides a global point of access to it. It is commonly used for logging, configuration, and resource management.

## Use Case
**Logger:** A logger class that guarantees only one instance handles all logging throughout the application.

## Structure
- `Logger`: Singleton class with a private constructor and a static getInstance method.

## How to Run
Run `LoggerDemo.java` to see that all log messages are handled by the same logger instance.
