# 🏁 Chessboard App

## Overview

The **Chessboard App** is a visually engaging Android application that replicates a chessboard layout. It dynamically adjusts to both portrait and landscape orientations, providing a seamless user experience. The app alternates the board's colors between traditional black-and-white and red-and-white schemes, depending on the device's orientation.

---

## Features

- **Dynamic Chessboard Layout**: Automatically adjusts to portrait or landscape mode.
- **Responsive Design**: Ensures proper alignment and square sizes based on screen dimensions.
- **Color Changes**:
  - **Portrait Mode**: Black and white squares.
  - **Landscape Mode**: Red and white squares.
- **Chess Piece Labels**: Displays row and column labels in standard chessboard format.
- **Lightweight Logic**: Utilizes a 2D array to manage chessboard state and appearance.

---

## Technical Details

- **Programming Language**: Java  
- **Framework**: Android SDK  
- **Design Pattern**: Model-View-Controller (MVC)  
- **Key Classes**:  
  - `ChessboardModel`: Manages the chessboard logic, including square colors and piece labels.  
  - `MainActivity`: Handles the UI and adapts to orientation changes.  

---

## How It Works

1. **Chessboard Initialization**:
   - An 8x8 grid is dynamically created using `GridLayout`.
   - Each square is styled with alternating colors and optional chess piece labels.

2. **Orientation Handling**:
   - The app listens for device orientation changes using `onConfigurationChanged`.
   - Color schemes are updated to match the current orientation.

3. **Responsive Sizing**:
   - Calculates square dimensions to fit the screen size.
   - Adapts for navigation bar height in landscape mode.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/ChessboardApp.git
