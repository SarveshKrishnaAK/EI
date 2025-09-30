# Command Pattern

## Overview
The Command Pattern encapsulates a request as an object, allowing for parameterization and queuing of requests. It decouples the sender from the receiver, making it easy to add new commands without changing existing code.

## Use Case
**Remote Control:** A remote control can execute different commands, such as turning on/off a light or opening/closing a door. Each action is represented as a command object.

## Structure
- `Command` interface: Declares the execute method.
- `LightOnCommand`, `LightOffCommand`: Concrete command classes.
- `Light`: Receiver class.
- `RemoteControl`: Invoker class.

## How to Run
Run `RemoteControlDemo.java` to see the remote control executing commands to turn the light on and off.
