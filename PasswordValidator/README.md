# PasswordChecker# Password Validator App

This is a simple Android app for validating password strength, created as a homework assignment for my CSCI 322/522 class. The app allows users to enter a password, and as the user types, it displays "WEAK" or "STRONG" based on the length of the password. A weak password has eight or fewer characters, while a strong password has nine or more. The app uses a Model-View-Controller (MVC) architecture and is designed to run in portrait orientation.

## Features

- **One Text Field**: The user can enter their password here.
- **One Label**: Displays "WEAK" or "STRONG" as the user types the password.
- **Custom Styling**: Both the text field and label have their own styles, each with a minimum of four attributes.
- **No Prewritten Password Validation Code**: All password validation logic is written from scratch.
- **MVC Pattern**: A separate model class is used to handle the password strength logic.

## Usage

1. Start typing a password in the text field.
2. The label will update as you type to display "WEAK" if the password has eight or fewer characters, or "STRONG" if the password has nine or more characters.

## Constraints

- The app does not use XML for layout design.
- Password validation is based solely on the length of the password.
- The app is locked to portrait orientation.
- The app does not use any prewritten password-checking libraries.

## Architecture

This app follows the MVC (Model-View-Controller) design pattern:
- **Model**: Handles the logic for determining password strength.
- **View**: Contains the UI elements (text field, label).
- **Controller**: Connects the logic and the UI elements, listening for user input and updating the label as the user types.

