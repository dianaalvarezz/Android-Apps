/************************************************************************
 *                                                                      *
 *                                                                      *
 *       App Name: Color App                                            *
 *                                                                      *
 *     Class Name: MainActivity.java                                    *
 *                                                                      *
 *   Developer(s): Diana Alvarez                                        *
 *                                                                      *
 *       Due Date: 9/27/2024                                            *
 *                                                                      *
 *        Purpose: App lets the user create a color using RGB color     *
 *        model that displays three text fields and one large label     *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.colorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity               
{

    private EditText redEditText;
    private EditText greenEditText;
    private EditText blueEditText;
    private TextView labelTextView;
    private ColorAppModel colorAppModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        redEditText = findViewById(R.id.red_color);
        greenEditText = findViewById(R.id.green_color);
        blueEditText = findViewById(R.id.blue_color);
        labelTextView = findViewById(R.id.app_label);

        // Creates instance of Color App Model
        colorAppModel = new ColorAppModel();

        // Set up the TextWatcher for each color
        TextChangerHandler tch = new TextChangerHandler();
        redEditText.addTextChangedListener(tch);
        greenEditText.addTextChangedListener(tch);
        blueEditText.addTextChangedListener(tch);
    }

    private class TextChangerHandler implements TextWatcher
    {

        @Override
        public void afterTextChanged(Editable s)
        {
            newColor();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        private void newColor()
        {
            String redString = redEditText.getText().toString();
            String greenString = greenEditText.getText().toString();
            String blueString = blueEditText.getText().toString();

            try
            {
                // Parse the input to integers and makes the empty field start at 0
                int redNum = Integer.parseInt(redString.isEmpty() ? "0" : redString);
                int greenNum = Integer.parseInt(greenString.isEmpty() ? "0" : greenString);
                int blueNum = Integer.parseInt(blueString.isEmpty() ? "0" : blueString);

                // send the color to the model to be validated
                redNum = colorAppModel.validate(redNum);
                greenNum = colorAppModel.validate(greenNum);                    
                blueNum = colorAppModel.validate(blueNum);

                // Checks if value entered is valid and corrects it if not
                if (!redString.equals(String.valueOf(redNum)))
                {
                    redEditText.setText(String.valueOf(redNum));
                    redEditText.setSelection(redEditText.getText().length());
                }

                if (!greenString.equals(String.valueOf(greenNum)))
                {
                    greenEditText.setText(String.valueOf(greenNum));
                    greenEditText.setSelection(greenEditText.getText().length());
                }

                if (!blueString.equals(String.valueOf(blueNum)))
                {
                    blueEditText.setText(String.valueOf(blueNum));
                    blueEditText.setSelection(blueEditText.getText().length());
                }

                // Updates the color of the label
                labelTextView.setBackgroundColor(Color.rgb(redNum, greenNum, blueNum));

            }
            catch (NumberFormatException e)
            {

            }
        }
    }
}
