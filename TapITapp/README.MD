# Tap It App

**Tap It** is a simple Android application that demonstrates single and double tap gestures, along with a tap counter.

## Features

- **Interactive Gesture Detection**:
  - Single Tap: Changes the background color of the top TextView to blue.
  - Double Tap: Changes the background color back to red.
- **Tap Counter**: Displays the total number of taps (single taps add 1, double taps add 2).
- **Clean Layout**:
  - A split-screen layout with:
    - A top TextView for gestures.
    - A bottom TextView for the tap count.

## How It Works

The app uses Android's `GestureDetector` to differentiate between single and double taps. A counter tracks the total taps and updates the screen accordingly.

## Layout

The app consists of two main components:
1. **Color-Changing TextView**: Occupies the top half of the screen.
2. **Tap Counter TextView**: Occupies the bottom half of the screen.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/TapItApp.git
