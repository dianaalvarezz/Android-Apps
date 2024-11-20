/************************************************************************
 *                                                                      *
 *  CSCI 322                   Assignment 6           Fall 2024         *
 *                                                                      *
 *       App Name: SQLite and Contacts List                             *
 *                                                                      *
 *     Class Name: MainActivity.java                                    *
 *                                                                      *
 *   Developer(s): Diana Alvarez                                        *
 *                                                                      *
 *       Due Date: 11/15/2024                                           *
 *                                                                      *
 *        Purpose: App that displays scrollable list of contacts with   *
 *        SQlite data base that you can add, edit or delete contacts    *
 *        from                                                          *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.contactslist;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    // AutoCompleteTextView to search for contact by email
    private AutoCompleteTextView searchEmail;

    // RecyclerView for displaying contacts
    private RecyclerView contactsRecyclerView;

    // Adapter for managing contact list
    private Contacts contactsAdapter;

    // Holds the contacts in list
    private List<Contact> contactList = new ArrayList<>();

    // Adapter for autocomplete email suggestions
    private ArrayAdapter<String> emailAdapter;

    //Helper for database
    private databsehelper dbHelper; // Declare dbHelper

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set the screen orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        // set the layout for the activity
        setContentView(R.layout.activity_main);

        // Initialize dbHelper
        dbHelper = new databsehelper(this);

        // Find views
        searchEmail = findViewById(R.id.searchEmail);
        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);
        Button addContactButton = findViewById(R.id.addContactButton);

        // Set up RecyclerView with layout
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadContacts(); // Load all contacts into the list
        contactsAdapter = new Contacts(contactList);
        contactsRecyclerView.setAdapter(contactsAdapter);

        // Set up AutoCompleteTextView for the email search field
        setupAutoComplete();
        searchEmail.setOnItemClickListener((parent, view, position, id) ->
        {
            String selectedEmail = emailAdapter.getItem(position);
            displayContactByEmail(selectedEmail);
        });

        // listen for changes in the search field to reload if list cleared
        searchEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (s.toString().isEmpty())
                {
                    loadContacts(); // Reload all contacts if search field is cleared
                    contactsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Add Contact button
        addContactButton.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
            startActivity(intent);
        });
    }

    // Sets up the AutoCompleteTExtView with email suggestions when typed in
    private void setupAutoComplete()
    {
        List<String> emails = new ArrayList<>();
        for (Contact contact : dbHelper.getAllContacts())
        {
            emails.add(contact.getEmail());
        }

        emailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, emails);
        searchEmail.setAdapter(emailAdapter);
    }

    // Loads the contacts into the list
    private void loadContacts()
    {
        contactList.clear();
        contactList.addAll(dbHelper.getAllContacts());
    }

    // Filters the contacts by email
    private void displayContactByEmail(String email)
    {
        Contact contact = dbHelper.getContactByEmail(email);

        contactList.clear();
        if (contact != null)
        {
            contactList.add(contact);
        }
        contactsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        loadContacts(); // Reload the contact list
        contactsAdapter.notifyDataSetChanged();
        setupAutoComplete(); // Update the AutoCompleteTextView emails
    }
}
