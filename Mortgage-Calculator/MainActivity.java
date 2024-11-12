package edu.niu.android.mortgage;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static Mortgage mortgage;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void modifyData(View v)
    {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }
}
