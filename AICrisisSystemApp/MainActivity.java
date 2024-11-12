package edu.niu.android.aicrisisasystemapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the "I am Trapped" button by its ID
        Button hurtButton = findViewById(R.id.HurtButton);

        // Set an OnClickListener to launch Hurt activity when the button is clicked
        hurtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start Hurt.java activity
                Intent intent = new Intent(MainActivity.this, Hurt.class);
                startActivity(intent); // Start Hurt activity
            }
        });

        // Find the "Evacuate" button by its ID
        Button evacuateButton = findViewById(R.id.button2);

        // Set an OnClickListener to launch CanEvacuateButton activity when the button is clicked
        evacuateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start CanEvacuateButton.java activity
                Intent intent = new Intent(MainActivity.this, CanEvacuateButton.class);
                startActivity(intent); // Start CanEvacuateButton activity
            }
        });
    }
}
