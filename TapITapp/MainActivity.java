package edu.niu.android.tapit;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{


    private TextView textView; // Reference to the color changing TextView
    private TextView tapCountTextView; // Reference to tap count TextView
    private GestureDetector gestureDetector; // Detects the taps
    private int tapCount = 0; // Counts the taps

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Calls onCreate class
        super.onCreate(savedInstanceState);

        // Sets up the layout from activity_main
        setContentView(R.layout.activity_main);

        // Binds the TextViews to the java function
        textView = findViewById(R.id.textView);
        tapCountTextView = findViewById(R.id.tapCountTextView);


        // Function to handle the single and double taps
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            // Single taps
            @Override
            public boolean onSingleTapConfirmed(@NonNull MotionEvent e)
            {
                Log.d("Gesture", "Single Tap Detected!");

                // Change the color to blue on single taps if red
                textView.setBackgroundColor(Color.BLUE);

                // Increment tap count by 1
                incrementTapCount(1);
                return true;
            }

            // Double taps
            @Override
            public boolean onDoubleTap(@NonNull MotionEvent e)
            {
                Log.d("Gesture", "Double Tap Detected!");

                // Change the color back to red on double taps if red
                textView.setBackgroundColor(Color.RED);

                // Increment tap count by 2
                incrementTapCount(2);
                return true;
            }

            @Override
            public boolean onDown(@NonNull MotionEvent e)
            {
                // Returns true
                return true;
            }
        });

        // Forwards touch events to GestureDetector
        textView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));
    }

    // Increment the tap count and updates the TextView
    private void incrementTapCount(int count)
    {
        tapCount += count;
        tapCountTextView.setText("Tap Count: " + tapCount);
    }
}
