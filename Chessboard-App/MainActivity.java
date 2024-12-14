/************************************************************************
 *                                                                      *
 *  CSCI 322                   Assignment 7           Fall 2024         *
 *                                                                      *
 *       App Name: Chessboard App                                       *
 *                                                                      *
 *     Class Name: MainActivity.java                                    *
 *                                                                      *
 *   Developer(s): Diana Alvarez                                        *
 *                                                                      *
 *       Due Date: 12/06/2024                                           *
 *                                                                      *
 *        Purpose: App that is a chessboard that works in both vertical *
 *        and horizontal orientations and switches colors when the      *
 *        orientation is switched                                       *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.chessboard;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    // Stores the colors logic
    private ChessboardModel chessboardModel;

    // Method that sets up bored based on current orientation
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        chessboardModel = new ChessboardModel();

        // Initializes the activity and sets up bored based on current orientation
        setupChessboard(getResources().getConfiguration().orientation);
    }


    // Method that creates the chessboard UI
    private void setupChessboard(int orientation)
    {
        FrameLayout frameLayout = new FrameLayout(this);

        // Creates an 8x8 GridLayout for the chessboard
        GridLayout chessboard = new GridLayout(this);
        chessboard.setRowCount(8);
        chessboard.setColumnCount(8);

        // Calculates square size based on screen
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int squareSize;

        if (orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            // Creates full width for portrait mode
            squareSize = screenWidth / 8;
        }
        else
        {
            // Creates full height for landscape mode
            squareSize = Math.min(screenWidth / 8, (screenHeight - getNavigationBarHeight()) / 8);
        }

        // Loop that creates each row and column
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                TextView square = new TextView(this);

                boolean isBlack = chessboardModel.isBlackSquare(row, col);
                if (orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    // Sets the color to black and white
                    square.setBackgroundColor(isBlack ? Color.BLACK : Color.WHITE);
                }
                else
                {
                    // Sets the color to red and white
                    square.setBackgroundColor(isBlack ? Color.RED : Color.WHITE);
                }

                // Chess Pieces
                String piece = chessboardModel.getPieceAt(row, col);
                square.setText(piece);
                square.setTextColor(isBlack ? Color.WHITE : Color.BLACK);
                square.setTextSize(20);
                square.setGravity(Gravity.CENTER);

                // Square size
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = squareSize;
                params.height = squareSize;
                square.setLayoutParams(params);

                chessboard.addView(square);
            }
        }

        // Set layout parameters for the chessboard inside the FrameLayout
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            // Aligns to top in portait
            frameParams.gravity = Gravity.TOP;
        }
        else
        {
            // Centers if in landscape
            frameParams.gravity = Gravity.CENTER;
        }
        chessboard.setLayoutParams(frameParams);

        // Add the chessboard to the FrameLayout
        frameLayout.addView(chessboard);

        // Set the FrameLayout as the content view
        setContentView(frameLayout);
    }

    // Calculates the height to adujust layout in landscape
    private int getNavigationBarHeight()
    {
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return resourceId > 0 ? getResources().getDimensionPixelSize(resourceId) : 0;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Re-setup the chessboard based on the new orientation
        setupChessboard(newConfig.orientation);
    }
}
