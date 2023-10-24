package com.example.zoomdeimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1_with_input, btn2_with_scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn2_with_scroll=findViewById(R.id.btn2);
         btn1_with_input=findViewById(R.id.btn1);
        btn1_with_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2_main.class);
                startActivity(intent);
            }
        });
        btn2_with_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, With_zoom.class);
                startActivity(intent);
            }
        });
    }
}