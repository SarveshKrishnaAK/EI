# Facade Pattern

## Overview
The Facade Pattern provides a unified interface to a set of interfaces in a subsystem, making it easier to use and reducing complexity for the client.

## Use Case
**Home Theater System:** A single interface starts the projector, sound system, and dims the lights, simplifying the process for the user.

## Structure
- `Projector`, `SoundSystem`, `Lights`: Subsystem classes.
- `HomeTheaterFacade`: Facade class that provides simple methods to start and end a movie.

## How to Run
Run `HomeTheaterFacadeDemo.java` to see the home theater system started and ended using the facade.
