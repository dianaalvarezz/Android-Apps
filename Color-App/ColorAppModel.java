/************************************************************************
 *                                                                      *
 *     Class Name: ColorAppModel.java                                   *
 *                                                                      *
 *        Purpose: Class that validates the users input to make sure    *
 *        the input is between 0 - 255 and if it is not, it will change *
 *        it automatically                                              *
 *                                                                      *
 ************************************************************************/
package edu.niu.android.colorapp;

public class ColorAppModel
{
    // Method that validates the input is between 0 - 255
    public int validate(int num)
    {

        //if user enters a negative value, it is converted to 0
        if(num < 0)
        {
            num = 0;
        }

        // If the user enters a value greater than 255 it is converted to 255
        else if (num > 255)
        {
            num = 255;
        }

        return num;
    }
}
