# Proxy Pattern

## Overview
The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. It is useful for lazy loading, access control, logging, and more.

## Use Case
**Image Viewer:** Loads a placeholder and only loads the actual image from disk when needed, optimizing resource usage.

## Structure
- `Image` interface: Declares the display method.
- `RealImage`: Actual image class.
- `ProxyImage`: Proxy class that loads the image only when required.

## How to Run
Run `ImageViewerDemo.java` to see the image loaded only when display is called for the first time.
