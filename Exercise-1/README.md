*This is a part of a placement drive that demonstrates my understanding of real-world use cases involving six design patterns.*

---

# Exercise 1: Software Design Patterns Showcase

## Overview
This project demonstrates six fundamental software design patterns in Java, each implemented with a simple, real-world use case. The patterns are organized for clarity and easy reference, making it ideal for interviews, learning, and practical demonstration.

## Patterns & Use Cases
- **Creational Patterns**
  - **Singleton Pattern:** Logger class ensuring only one instance handles all logging.
  - **Factory Method Pattern:** Notification system that creates Email, SMS, or Push notifications based on user input.
- **Structural Patterns**
  - **Proxy Pattern:** Image viewer that loads a placeholder and only loads the actual image when needed.
  - **Facade Pattern:** Home theater system with a unified interface to start projector, sound system, and lights.
- **Behavioural Patterns**
  - **Command Pattern:** Remote control that executes commands (turn on/off light) based on user input.
  - **Strategy Pattern:** Payment system allowing users to select and switch between payment methods interactively.

## Key Features
- Each pattern is implemented in its own folder for modularity.
- User input is integrated in Command, Strategy, and Factory Method patterns for interactive demonstration.
- Logging and exception handling follow best practices.

## How to Run
1. Compile all Java files in the `src` folder and the main demo file for each pattern. Example:
   ```powershell
   javac -d . src\*.java PatternDemo.java
   java PatternDemo
   ```
2. For interactive patterns, follow the prompts in the console.

## Example Workflow
- Run the Command Pattern demo and enter "on" or "off" to control the light.
- Run the Strategy Pattern demo and select a payment method and amount.
- Run the Factory Method Pattern demo and choose notification type and message.


## Project Structure
- `Exercise-1/BehaviouralPattern/CommandPattern/src/` — Command pattern classes
- `Exercise-1/BehaviouralPattern/StrategyPattern/src/` — Strategy pattern classes
- `Exercise-1/CreationalPattern/SingletonPattern/src/` — Singleton pattern classes
- `Exercise-1/CreationalPattern/FactoryMethodPattern/src/` — Factory method pattern classes
- `Exercise-1/StructuralPattern/ProxyPattern/src/` — Proxy pattern classes
- `Exercise-1/StructuralPattern/FacadePattern/src/` — Facade pattern classes

## Design and Best Practices
- Follows SOLID principles and global coding standards.
- Defensive programming and input validation throughout.
- Modular, extensible structure for easy addition of new patterns or use cases.

## Author and Contact
- **Author:** Sarvesh Krishna A K
- **Email:** sarveshkrishnaak@gmail.com
- **LinkedIn:** [sarveshkrishnaak](https://www.linkedin.com/in/sarveshkrishnaak)

---
For any queries or feedback, feel free to reach out via email or LinkedIn.
