# Addition App

## Overview
This is a simple Android application developed for **CSCI 322/522** as part of Assignment 3, which focuses on implementing the MVC (Model-View-Controller) design pattern and utilizing UI components and events. The app performs basic addition of two positive integers entered by the user in two text fields.

## Features
- **Two Input Fields**: Users can input two positive integers.
- **Addition Button**: A button is provided to perform the addition of the two integers.
- **Result Display**: The result of the addition is displayed in a label.
- **Stylized UI**: 
  - The two text fields share a consistent style with at least four attributes.
  - The label and button share a different style, also with at least four attributes.
- **Vertically Centered Layout**: All components (text fields, label, button) are centered vertically within the app.
- **MVC Pattern**: The app follows the MVC pattern, separating the business logic (model) from the user interface.

## UI Components
- **Text Fields**: Accept positive integer inputs from the user.
- **Button**: Triggers the addition operation.
- **Label**: Displays the result of the addition.

## How It Works
1. The user enters two positive integers in the provided text fields.
2. Upon clicking the "Add" button, the two integers are added together.
3. The result is displayed in the label below the text fields.
4. The application ensures that the input fields, label, and button are appropriately styled and vertically aligned for a consistent user experience.

## Styles
- **Text Field Style**:
  - Minimum of four attributes applied.
  - Ensures consistency between the two input fields.
  
- **Label & Button Style**:
  - A separate style is applied to both the label and the button, which is different from the text field style.
  - Also contains a minimum of four attributes to enhance visual appearance and usability.

## MVC Pattern
- **Model**: Handles the addition logic and stores the result.
- **View**: Displays the user interface components, including the text fields, label, and button.
- **Controller**: Manages user interactions, such as adding the two numbers when the button is clicked.

## Additional Features
- **Action Bar**: If enabled, the action bar displays the title "Addition" to represent the functionality of the app.

## Requirements
- **Android SDK**: The app is developed for Android devices.
- **Languages Used**: Java (for app logic and MVC implementation).

## How to Run
1. Clone or download the project.
2. Open it in Android Studio.
3. Build and run the app on an emulator or Android device.

## Author
Developed by Diana Alvarez for CSCI 322/522, Assignment 3.
