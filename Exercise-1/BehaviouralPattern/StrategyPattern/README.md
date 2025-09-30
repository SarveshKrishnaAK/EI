# Strategy Pattern

## Overview
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to vary independently from clients that use it.

## Use Case
**Payment System:** The system can switch between different payment methods (Credit Card, PayPal, Crypto) at runtime without changing the client code.

## Structure
- `PaymentStrategy` interface: Declares the pay method.
- `CreditCardPayment`, `PayPalPayment`, `CryptoPayment`: Concrete strategy classes.
- `PaymentContext`: Context class that uses a strategy.

## How to Run
Run `PaymentStrategyDemo.java` to see payments processed using different strategies.
