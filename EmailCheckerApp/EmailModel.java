package edu.niu.android.emailcheckerapp;

public class EmailModel
{
    public boolean EmailChecker(String email)
    {
        // Makes sure there is a . after the @ character in the email
        int pos = email.indexOf('@');
        return pos > -1 && email.indexOf('.', pos) > pos;
    }
}
