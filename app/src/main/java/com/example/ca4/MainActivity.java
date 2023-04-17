package com.example.ca4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText  name;
    Button search;
    TextView dname,dprice,dmanu,dcat,dstock;
    FirebaseDatabase rootNode;
    DatabaseReference userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        search = findViewById(R.id.search);
        dname = findViewById(R.id.dname);
        dprice = findViewById(R.id.dprice);
        dmanu = findViewById(R.id.dmanu);
        dcat = findViewById(R.id.dcat);
        dstock = findViewById(R.id.dstock);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aName = name.getText().toString();
                if (!aName.isEmpty()){

                    readData(aName);
                }else{

                    Toast.makeText(MainActivity.this,"PLease Enter Username",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void readData(String aName){
        userDB = FirebaseDatabase.getInstance().getReference("Items");
        userDB.child(aName).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){

                        Toast.makeText(MainActivity.this,"Successfully Read",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();


                        String product = String.valueOf(dataSnapshot.child("name").getValue());
                        String price = String.valueOf(dataSnapshot.child("price").getValue());
                        String manu = String.valueOf(dataSnapshot.child("manu").getValue());
                        String cat = String.valueOf(dataSnapshot.child("cat").getValue());
                        String stock = String.valueOf(dataSnapshot.child("stock").getValue());
                        dname.setText(product);
                        dprice.setText(price);
                        dmanu.setText(manu);
                        dcat.setText(cat);
                        dstock.setText(stock);

                    }else {

                        Toast.makeText(MainActivity.this,"User Doesn't Exist",Toast.LENGTH_SHORT).show();

                    }


                }else {

                    Toast.makeText(MainActivity.this,"Failed to read",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}