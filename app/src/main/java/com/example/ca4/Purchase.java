package com.example.ca4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Purchase extends AppCompatActivity {
    EditText card, name,expiry,security;
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        card = findViewById(R.id.Card);
        name  = findViewById(R.id.Name);
        expiry = findViewById(R.id.Expiry);
        security  = findViewById(R.id.Security);
        pay = findViewById(R.id.Pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Purchase.this, review.class));
            }
        });
    }
}