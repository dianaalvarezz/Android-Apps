/************************************************************************
 *                                                                      *
 *  CSCI 322                   Assignment 5           Fall 2024         *
 *                                                                      *
 *       App Name: Taylor Swift Tic Tac Toe                             *
 *                                                                      *
 *     Class Name: MainActivity.java                                    *
 *                                                                      *
 *   Developer(s): Diana Alvarez                                        *
 *                                                                      *
 *       Due Date: 11/04/2024                                           *
 *                                                                      *
 *        Purpose: This class displays 9 ImageButtons, each             *
 *        representing a Taylor Swift album. When an album is clicked.  *
 *        it navigates to a second activity displaying a larger version *
 *        of the album image and relevant information about the album   *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up all ImageButtons
        setUpImageButtons();
    }

    private void setUpImageButtons()
    {
        // Loop through all 9 buttons to set up listeners
        for (int i = 0; i < 9; i++) {
            int buttonId = getResources().getIdentifier("imageButton" + (i + 1), "id", getPackageName());
            ImageButton button = findViewById(buttonId);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    navigateToSecondActivity(finalI);
                }
            });
        }
    }

    // Passes information to the second activity
    private void navigateToSecondActivity(int index)
    {
        Intent intent = new Intent(MainActivity.this, ImageDisplay.class);
        intent.putExtra("image_id", Album.getImage(index));
        intent.putExtra("description", Album.getName(index));
        intent.putExtra("extra_info", Album.getExtraInfo(index));
        startActivity(intent);
    }
}
