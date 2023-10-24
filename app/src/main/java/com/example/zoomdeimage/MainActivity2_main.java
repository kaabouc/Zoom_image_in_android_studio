package com.example.zoomdeimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity2_main extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWidth;
    private ImageView imageView;
    private Button buttonEnter;
    private Button buttonAddImage;
    private static final int PICK_IMAGE = 1;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWidth = findViewById(R.id.editTextWidth);
        imageView = findViewById(R.id.imageView1);
        buttonEnter = findViewById(R.id.buttonEnter);
        buttonAddImage = findViewById(R.id.buttonAddImage1);

        // Initialisation des détecteurs de gestes


        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = editTextHeight.getText().toString();
                String widthText = editTextWidth.getText().toString();

                if (!heightText.isEmpty() && !widthText.isEmpty()) {
                    int height = Integer.parseInt(heightText);
                    int width = Integer.parseInt(widthText);

                    // Set the new dimensions for the ImageView
                    imageView.getLayoutParams().height = height;
                    imageView.getLayoutParams().width = width;
                    imageView.requestLayout();
                }
            }
        });

        buttonAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE);
            }
        });


    }

    // Classe pour gérer le zoom


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}