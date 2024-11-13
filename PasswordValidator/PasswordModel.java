package edu.niu.android.passwordvalidator;

public class PasswordModel
{
    public boolean passwordStrength(String password)
    {
        // checks password length
       int length = password.length();
       return length <=  8;
    }
}
