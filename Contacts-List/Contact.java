/************************************************************************
 *                                                                      *
 *     Class Name: Contact.java                                         *
 *                                                                      *
 *        Purpose: RecyclerView adapter for displaying, editing, and    *
 *        deleting contacts stored in the SQLite database               *
 *                                                                      *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.contactslist;

public class Contact
{

    public String fName; // First name
    public String lName; // Last name
    public String emailId; // Email ID
    public long phoneNumber; // Phone Number

    public Contact(String firstName, String lastName, String email, long phone)
    {
        fName = firstName; // first name
        lName = lastName; // Last Name
        emailId = email; // Email
        phoneNumber = phone; // Phone number
    }

    // Returns first name of contact
    public String getFirstName() {
        return fName;
    }

    // Returns last name of contact
    public String getLastName() {
        return lName;
    }

    // Returns email of contact
    public String getEmail() {
        return emailId;
    }

    // Returns phone number of contact
    public long getPhone() {
        return phoneNumber;
    }
}
