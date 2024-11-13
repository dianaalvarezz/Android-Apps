package edu.niu.android.passwordvalidator;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
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

        // Create the layout manager as a GridLayout (1 by 2)
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(2);

        // Initialize the TextView
        textView = new TextView(this);
        textView.setText("Password Strength");
        textView.setTextColor(Color.parseColor("#FF1493"));
        textView.setBackgroundColor(Color.parseColor("#DCD0FF"));
        textView.setWidth(600);
        textView.setHeight(150);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);

        // Create the EditText
        edittext = new EditText(this);
        edittext.setHint("Enter Password");
        edittext.setTextColor(Color.parseColor("#800080"));
        edittext.setBackgroundColor(Color.parseColor("#FFB6C1"));
        edittext.setWidth(1100);


        PasswordModel passwordModel = new PasswordModel();


        // Add TextWatcher checks for text change
        edittext.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // Creates new instance of PasswordModel
                String password = s.toString();
                boolean isWeak = passwordModel.passwordStrength(password);

                if (isWeak)
                {
                    // if 8 or less characters
                    textView.setText("WEAK");
                }
                else
                {
                    // of 9 or more characters
                    textView.setText("STRONG");
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        // LayoutParams for EditText
        GridLayout.LayoutParams editTextParams = new GridLayout.LayoutParams();
        editTextParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        editTextParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        editTextParams.setGravity(Gravity.CENTER);
        gridLayout.addView(edittext, editTextParams);


        // LayoutParams for TextView
        GridLayout.LayoutParams textViewParams = new GridLayout.LayoutParams();
        textViewParams.setGravity(Gravity.CENTER);
        gridLayout.addView(textView, textViewParams);


        setContentView(gridLayout);
    }
}
