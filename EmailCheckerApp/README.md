# Email Validator App

This is a simple Android app for validating email addresse. The app allows users to enter an email address and checks whether it contains both an `@` character and a dot `.` somewhere after the `@` symbol. If the email is valid, the app displays "VALID" in the label; otherwise, it displays "INVALID." The app is designed to run in portrait orientation, and it uses a Model-View-Controller (MVC) architecture.

## Features

- **One Text Field**: The user can enter their email address here.
- **One Button**: On click, the app checks the entered email address for validity.
- **One Label**: Displays whether the email is "VALID" or "INVALID."
- **Custom Styling**: Both the text field and label have their own styles, each with a minimum of four attributes.
- **No Prewritten Email Validation Code**: All email validation logic is written from scratch.
- **MVC Pattern**: A separate model class is used to handle the email validation logic.

## Usage

1. Enter an email address in the text field.
2. Click the button to check the validity of the email.
3. The label will update to show "VALID" if the email meets the criteria, otherwise it will show "INVALID."

## Constraints

- The app does not use XML for layout design.
- Email validation is based on the presence of an `@` symbol and a dot `.` after it.
- The app is locked to portrait orientation.
- The app does not use any prewritten email validation libraries.

## Architecture

This app follows the MVC (Model-View-Controller) design pattern:
- **Model**: Handles the logic for validating the email.
- **View**: Contains the UI elements (text field, button, label).
- **Controller**: Connects the logic and the UI elements, listening for user actions and updating the UI based on the results.
