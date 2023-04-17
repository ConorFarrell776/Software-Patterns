package com.example.ca4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class review extends AppCompatActivity {
    EditText text, star;
    Button review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        text = findViewById(R.id.Text);
        star  = findViewById(R.id.Rating);
        review = findViewById(R.id.Review);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(review.this, MainActivity.class));
            }
        });
    }
}