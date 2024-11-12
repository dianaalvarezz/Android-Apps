
package edu.niu.android.emailcheckerapp;

import android.graphics.Point;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity
{
    private Button button;
    private EditText edittext;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        buildUiByCode();
    }

    public void buildUiByCode()
    {
        // Get width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        // Create the layout manager as a GridLayout (1 by 3)
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(3);

        // Create the EditText
        edittext = new EditText(this);
        edittext.setHint("Enter Email");
        edittext.setTextSize(23);
        edittext.setPadding(20, 20, 20, 20);
        edittext.setTextColor(Color.parseColor("#800080"));
        edittext.setBackgroundColor(Color.parseColor("#FFB6C1"));
        edittext.setWidth(700);
        edittext.setHeight(200);
        edittext.setGravity(Gravity.CENTER);

        // Create the Button
        button = new Button(this);
        button.setText("Check Email");
        button.setTextSize(18);
        button.setPadding(20, 20, 20, 20);
        button.setTextColor(Color.BLACK);
        button.setWidth(500);
        button.setBackgroundColor(Color.LTGRAY);


        // Create the TextView
        textView = new TextView(this);
        textView.setText("Result");
        textView.setTextSize(40);
        textView.setPadding(20, 20, 20, 20);
        textView.setTextColor(Color.parseColor("#FF1493"));
        textView.setBackgroundColor(Color.parseColor("#DCD0FF"));
        textView.setWidth(600);
        textView.setHeight(300);
        textView.setGravity(Gravity.CENTER);

        int marginSize = 200;

        // LayoutParams for EditText
        GridLayout.LayoutParams editTextParams = new GridLayout.LayoutParams();
        editTextParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        editTextParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        editTextParams.setGravity(Gravity.CENTER);
        editTextParams.setMargins(marginSize, marginSize, marginSize, marginSize);
        gridLayout.addView(edittext, editTextParams);

        // LayoutParams for Button
        GridLayout.LayoutParams buttonParams = new GridLayout.LayoutParams();
        buttonParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        buttonParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        buttonParams.setGravity(Gravity.CENTER);
        editTextParams.setMargins(marginSize, marginSize, marginSize, marginSize);
        gridLayout.addView(button, buttonParams);

        // LayoutParams for TextView
        GridLayout.LayoutParams textViewParams = new GridLayout.LayoutParams();
        textViewParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        textViewParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        textViewParams.setGravity(Gravity.CENTER);
        editTextParams.setMargins(marginSize, marginSize, marginSize, marginSize);
        gridLayout.addView(textView, textViewParams);

        // Set gridLayout as the View of this Activity
        setContentView(gridLayout);

        // Set Button click listener
        ButtonHandler bh = new ButtonHandler();
        button.setOnClickListener(bh);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        public void onClick(View v)
        {
            String email = edittext.getText().toString();

            // Create instance of EmailModel
            EmailModel emailModel = new EmailModel();
            Boolean isValid = emailModel.EmailChecker(email);

            if (isValid)
            {
                textView.setText("VALID");
            }
            else
            {
                textView.setText("INVALID");
            }
        }
    }
}
