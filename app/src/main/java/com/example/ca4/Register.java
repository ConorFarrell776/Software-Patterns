package com.example.ca4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText email,name, password,address,payment;
    Button register;
    FirebaseAuth mAuth;
    TextView login;
    FirebaseDatabase rootNode;
    DatabaseReference userDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email);
        name = findViewById(R.id.register_name);
        password = findViewById(R.id.register_password);
        register  = findViewById(R.id.register);
        address = findViewById(R.id.address);
        payment  = findViewById(R.id.paymentMethods);
        login = findViewById(R.id.text_login);
        userDB = FirebaseDatabase.getInstance().getReference().child("Users");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
                Register();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

    }

    private void insertUser() {
        String aEmail = email.getText().toString();
        String aAddress = address.getText().toString();
        String aPayment = payment.getText().toString();
        String aName = name.getText().toString();
        boolean aAdmin = false;

        User user = new User(aEmail,aName,aAddress,aPayment,aAdmin);
        rootNode = FirebaseDatabase.getInstance();
        userDB = rootNode.getReference("User");
        userDB.child(aName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

    }

    private void Register()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(user.isEmpty())
        {
            email.setError("Email can not be empty");
        }
        if(pass.isEmpty())
        {
            password.setError("Password can not be empty");
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(Register.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}