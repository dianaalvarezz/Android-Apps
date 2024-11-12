/************************************************************************
 *                                                                      *
 *                                                                      *
 *       App Name: Addition App                                         *
 *                                                                      *
 *     Class Name: MainActivity.java                                    *
 *                                                                      *
 *   Developer(s): Diana Alvarez                                        *
 *                                                                      *
 *       Due Date: 9/27/2024                                            *
 *                                                                      *
 *        Purpose: App that performs addition and that displays two     *
 *        text fields, one label and one button                         *
 *                                                                      *
 ************************************************************************/


package edu.niu.android.additionapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    private EditText firstEditText;
    private EditText secondEditText;
    private TextView labelTextView;
    private Button button2;
    private AdditionModel additionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initilizes UI components
        firstEditText = findViewById(R.id.first_number);
        secondEditText = findViewById(R.id.second_number);
        labelTextView = findViewById(R.id.app_label);
        button2 = findViewById(R.id.button_add);

        // Creates instance of Addition Model
        additionModel = new AdditionModel();

        // Everytime the button is clicked the add() method is called
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                add();
            }
        });
    }

    public void add()
    {
        // Converts input to strings
        String firstString = firstEditText.getText().toString();
        String secondString = secondEditText.getText().toString();

        try
        {
            // Converts string input to integers
            int firstNum = Integer.parseInt(firstString);
            int secondNum = Integer.parseInt(secondString);

            // Sends numbers to model to perform addition
            int total = additionModel.add(firstNum, secondNum);

            // Displays the addition results in the label
            labelTextView.setText(String.valueOf(total));

        }
        catch (NumberFormatException nfe)
        {

        }
    }
}
