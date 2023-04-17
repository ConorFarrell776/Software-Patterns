package com.example.ca4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Update extends AppCompatActivity {
    EditText name,address,payment;
    Button update;
    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference userDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.name);
        address  = findViewById(R.id.address);
        payment = findViewById(R.id.payment);
        update = findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dname = name.getText().toString();
                updatedata(dname);
            }
        });
    }

    private void updatedata( String aname) {


        userDB = FirebaseDatabase.getInstance().getReference("User");
        userDB.child(aname).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){


                        DataSnapshot dataSnapshot = task.getResult();
                        userDB.child(aname).child("address").setValue(address.getText().toString());
                        userDB.child(aname).child("payment").setValue(payment.getText().toString());

                    }else {

                        Toast.makeText(Update.this,"Unable to Update",Toast.LENGTH_SHORT).show();

                    }


                }else {

                    Toast.makeText(Update.this,"Unable to buy",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navigate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.Home:
                startActivity(new Intent(Update.this, MainActivity.class));
                return true;
            case R.id.Update:
                startActivity(new Intent(Update.this, Update.class));
                return true;

            case R.id.Add:
                startActivity(new Intent(Update.this, Add.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}