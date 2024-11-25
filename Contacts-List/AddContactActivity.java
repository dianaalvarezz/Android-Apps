/************************************************************************
 *                                                                      *
 *     Class Name: AddContactActivity.java                              *
 *                                                                      *
 *        Purpose: TO allow users to add or edit contact details in     *
 *        the database by allowing input of contact details             *
 *                                                                      *
 *                                                                      *
 ************************************************************************/


package edu.niu.android.contactslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity
{

    // Field for contact details
    private EditText firstNameInput, lastNameInput, emailInput, phoneInput;

    // Helper class
    private databsehelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        // Intializes the database helper
        dbHelper = new databsehelper(this);

        // Binds the UI elements
        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        Button saveButton = findViewById(R.id.saveButton);

        // Adds formatting to the phone number input field
        phoneInput.addTextChangedListener(new PhoneNumberFormattingWatcher());

        // for editing
        String contactEmail = getIntent().getStringExtra("contactEmail");
        if (contactEmail != null)
        {
            Contact contact = dbHelper.getContactByEmail(contactEmail);
            if (contact != null)
            {
                firstNameInput.setText(contact.getFirstName());
                lastNameInput.setText(contact.getLastName());
                emailInput.setText(contact.getEmail());
                emailInput.setEnabled(false);
                phoneInput.setText(formatPhoneNumber(contact.getPhone()));
            }
        }

        // Save button click listner
        saveButton.setOnClickListener(v ->
        {
            // Collect user input
            String firstName = firstNameInput.getText().toString().trim();
            String lastName = lastNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String phoneStr = phoneInput.getText().toString().replaceAll("[^\\d]", "");

            // Makes sure inputs are good
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneStr.isEmpty() || phoneStr.length() != 10)
            {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert string phone to long phone
            long phone = Long.parseLong(phoneStr);

            // Create a contact object
            Contact contact = new Contact(firstName, lastName, email, phone);

            // Insert contact based on context
            if (contactEmail != null)
            {
                dbHelper.updateContact(contact);
                Toast.makeText(this, "Contact updated", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (dbHelper.insertContact(contact))
                {
                    // Message for when contact added
                    Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Message incase contact can not be added because alread exists
                    Toast.makeText(this, "Email already exists", Toast.LENGTH_SHORT).show();
                }
            }
            finish();
        });
    }

    // Formats a phone number into phone pattern
    private String formatPhoneNumber(long phone)
    {
        // Make sure the number has 10 digits
        String phoneStr = String.format("%010d", phone);
        return String.format("(%s) %s-%s", phoneStr.substring(0, 3), phoneStr.substring(3, 6), phoneStr.substring(6));
    }

    // Adds formatting in real time
    private class PhoneNumberFormattingWatcher implements TextWatcher
    {
        private boolean isFormatting;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s)
        {
            if (isFormatting) return;
            isFormatting = true;

            // formats by length
            String formatted = s.toString().replaceAll("[^\\d]", "");
            if (formatted.length() >= 6)
            {
                formatted = String.format("(%s) %s-%s", formatted.substring(0, 3), formatted.substring(3, 6), formatted.substring(6));
            }
            else if (formatted.length() >= 3)
            {
                formatted = String.format("(%s) %s", formatted.substring(0, 3), formatted.substring(3));
            }

            s.replace(0, s.length(), formatted);
            isFormatting = false;
        }
    }
}
