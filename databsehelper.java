/************************************************************************
 *                                                                      *
 *     Class Name: databsehelper.java                                   *
 *                                                                      *
 *        Purpose: Helps manage SQLite database operations like getting *
 *        contact information                                           *
 *                                                                      *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.contactslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class databsehelper extends SQLiteOpenHelper
{

    // Database configs
    private static final String DB_NAME = "ContactsListDatabase";
    private static final int DB_VERSION = 1;

    // Table and column names
    public static final String CONTACTS_TABLE = "contacts_table";
    public static final String FIRSTNAME_COL = "first_name";
    public static final String LASTNAME_COL = "last_name";
    public static final String EMAIL_COL = "email";
    public static final String PHONE_COL = "phone";

    // Constructor
    public databsehelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Creates table query
        String createTableQuery = "CREATE TABLE " + CONTACTS_TABLE + " (" +
                FIRSTNAME_COL + " TEXT, " +
                LASTNAME_COL + " TEXT, " +
                EMAIL_COL + " TEXT PRIMARY KEY, " +
                PHONE_COL + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drops the table to recreate it
        db.execSQL("DROP TABLE IF EXISTS " + CONTACTS_TABLE);
        onCreate(db);
    }

    // Inserts a new contact into the database
    public boolean insertContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRSTNAME_COL, contact.getFirstName());
        values.put(LASTNAME_COL, contact.getLastName());
        values.put(EMAIL_COL, contact.getEmail());
        values.put(PHONE_COL, contact.getPhone());

        long result = db.insert(CONTACTS_TABLE, null, values);
        db.close();
        return result != -1; // Returns true if insertion was successful
    }

    // Retrieves all contacts from database
    public List<Contact> getAllContacts()
    {
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CONTACTS_TABLE, null);

        if (cursor.moveToFirst())
        {
            do
            {
                // Extracts contact details
                String firstName = cursor.getString(cursor.getColumnIndexOrThrow(FIRSTNAME_COL));
                String lastName = cursor.getString(cursor.getColumnIndexOrThrow(LASTNAME_COL));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL_COL));
                long phone = cursor.getLong(cursor.getColumnIndexOrThrow(PHONE_COL));

                // Add contact to the list
                contactList.add(new Contact(firstName, lastName, email, phone));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return contactList;
    }

    // retrieves a contact by their email address
    public Contact getContactByEmail(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CONTACTS_TABLE + " WHERE " + EMAIL_COL + " = ?", new String[]{email});

        if (cursor.moveToFirst())
        {
            // Extracts the contact details
            String firstName = cursor.getString(cursor.getColumnIndexOrThrow(FIRSTNAME_COL));
            String lastName = cursor.getString(cursor.getColumnIndexOrThrow(LASTNAME_COL));
            long phone = cursor.getLong(cursor.getColumnIndexOrThrow(PHONE_COL));

            cursor.close();
            db.close();
            return new Contact(firstName, lastName, email, phone);
        }

        cursor.close();
        db.close();
        return null;
    }

    // Deletes contact
    public boolean deleteContact(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(CONTACTS_TABLE, EMAIL_COL + " = ?", new String[]{email});
        db.close();
        return rowsDeleted > 0;
    }

    // Updates an existing contact
    public void updateContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRSTNAME_COL, contact.getFirstName());
        values.put(LASTNAME_COL, contact.getLastName());
        values.put(PHONE_COL, contact.getPhone());
        db.update(CONTACTS_TABLE, values, EMAIL_COL + " = ?", new String[]{contact.getEmail()});
        db.close();
    }
}
