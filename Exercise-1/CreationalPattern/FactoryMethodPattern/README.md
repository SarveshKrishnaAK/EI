# Factory Method Pattern

## Overview
The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. It promotes loose coupling by eliminating the need to bind application-specific classes into the code.

## Use Case
**Notification System:** Creates different types of notifications (Email, SMS, Push) based on user preference using a factory method.

## Structure
- `Notification` interface: Declares the notifyUser method.
- `EmailNotification`, `SMSNotification`, `PushNotification`: Concrete notification classes.
- `NotificationFactory`: Factory class to create notifications.

## How to Run
Run `NotificationFactoryDemo.java` to see notifications sent via different channels.
