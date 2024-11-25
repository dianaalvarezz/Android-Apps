/************************************************************************
 *                                                                      *
 *     Class Name: Contacts.java                                        *
 *                                                                      *
 *        Purpose: RecyclerView adapter to display, edit, and delete    *
 *        contact data from an SQLite database                           *
 *                                                                      *
 *                                                                      *
 ************************************************************************/


package edu.niu.android.contactslist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Contacts extends RecyclerView.Adapter<Contacts.ContactViewHolder>
{

    // Lists contacts to display
    private final List<Contact> contactArray;

    // Constructor that intitialize the contact list
    public Contacts(List<Contact> contactList)
    {
        this.contactArray = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // contact_items.xml layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_items, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position)
    {
        // Gets the current contact to be able to bind data
        Contact currentContact = contactArray.get(position);

        // Set contact details
        holder.contactName.setText(currentContact.getFirstName() + " " + currentContact.getLastName());

        // Set contact email
        holder.contactEmail.setText(currentContact.getEmail());

        // Formats the contact phone number
        holder.contactPhone.setText(formatPhoneNumber(currentContact.getPhone()));

        // Handle Edit button click
        holder.editBtn.setOnClickListener(v ->
        {
            Context ctx = holder.itemView.getContext();
            Intent editIntent = new Intent(ctx, AddContactActivity.class);

            // Pass contact details to AddContactActivity for editing
            editIntent.putExtra("contactFirstName", currentContact.getFirstName());
            editIntent.putExtra("contactLastName", currentContact.getLastName());
            editIntent.putExtra("contactEmail", currentContact.getEmail());
            editIntent.putExtra("contactPhone", currentContact.getPhone());

            // Start the file AddContactActivity, that will add contact activity
            ctx.startActivity(editIntent);
        });

        // set up Delete button click
        holder.deleteBtn.setOnClickListener(v ->
        {
            Context ctx = holder.itemView.getContext();
            databsehelper dbHelper = new databsehelper(ctx);

            // deletes the contact
            boolean isDeleted = dbHelper.deleteContact(currentContact.getEmail());

            if (isDeleted)
            {
                // Removes contact
                contactArray.remove(position);
                notifyItemRemoved(position);

                // Notifies that the contact was deleted
                Toast.makeText(ctx, "Deleted " + currentContact.getFirstName(), Toast.LENGTH_SHORT).show();
            }
            else
            {
                // Notifies that the contact was not deleted correctly
                Toast.makeText(ctx, "Error deleting contact", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        // Returns the number of contacts in the list
        return contactArray.size();
    }

    // Helper method to format phone numbers
    private String formatPhoneNumber(long phone)
    {
        String phoneStr = String.format("%010d", phone); // makes the phone number have 10 digits
        return String.format("(%s) %s-%s",
                phoneStr.substring(0, 3), // Area code
                phoneStr.substring(3, 6), // First 3 digits
                phoneStr.substring(6)); // Last 4 digits
    }

    // Class that holds and manages views for each contact item
    static class ContactViewHolder extends RecyclerView.ViewHolder
    {
        // Textview for contact details
        TextView contactName, contactEmail, contactPhone;

        //Buttons for editing and deleting a contact
        Button editBtn, deleteBtn;

        // Constructor to initialize the views
        public ContactViewHolder(@NonNull View itemView)
        {
            super(itemView );

            contactName = itemView.findViewById(R.id.contactName);
            contactEmail = itemView.findViewById(R.id.contactEmail);
            contactPhone = itemView.findViewById(R.id.contactPhone);
            editBtn = itemView.findViewById(R.id.editButton);
            deleteBtn = itemView.findViewById(R.id.deleteButton);
        }
    }
}
