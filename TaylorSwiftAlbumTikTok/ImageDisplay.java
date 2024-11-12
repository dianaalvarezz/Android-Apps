/************************************************************************
 *                                                                      *
 *     Class Name: ImageDisplay.java                                    *
 *                                                                      *
 *        Purpose: This class displays album image and the relevant     *
 *        information about the album                                   *
 *                                                                      *
 *                                                                      *
 ************************************************************************/

package edu.niu.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDisplay extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        // Retrieve data from my Album.java file
        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("image_id", 0);
        String description = intent.getStringExtra("description");
        String extraInfo = intent.getStringExtra("extra_info");

        // Set up the views
        ImageView imageView = findViewById(R.id.displayImageView);
        TextView descriptionView = findViewById(R.id.displayDescription);
        TextView extraInfoView = findViewById(R.id.displayExtraInfo);
        Button backButton = findViewById(R.id.backButton);

        // Populate the views with the data from my Album.java file
        imageView.setImageResource(imageResId);
        descriptionView.setText(description);
        extraInfoView.setText(extraInfo);

        // Bck button
        backButton.setOnClickListener(v -> finish());
    }
}
