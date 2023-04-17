package com.example.ca4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    EditText  name, price,manu,cat,stock;
    Button add;
    FirebaseDatabase rootNode;
    DatabaseReference itemDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        manu = findViewById(R.id.manu);
        cat = findViewById(R.id.cat);
        stock = findViewById(R.id.stock);
        add = findViewById(R.id.add);
        itemDB = FirebaseDatabase.getInstance().getReference().child("itemDB");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();

            }

        });
    }

    private void insertItem() {
        String aName = name.getText().toString();
        int aPrice = Integer.parseInt(price.getText().toString());
        String aManu = manu.getText().toString();
        String aCat = cat.getText().toString();
        int aStock = Integer.parseInt(stock.getText().toString());
        Items items = new Items(aName,aPrice,aManu,aCat,aStock);
        ElectronicFactory electronicFactory = new ElectronicFactory();
        ElectronicInterface electronicInterface = ElectronicFactory.getInterface("Laptop");
        if(aCat.equals("Laptop"))
        {
            electronicInterface = ElectronicFactory.getInterface("Laptop");
        } else if (aCat.equals("Phone")) {
            electronicInterface = ElectronicFactory.getInterface("Phone");
        }
        else if (aCat.equals("Ipad")) {
        electronicInterface = ElectronicFactory.getInterface("Ipad");

        }
        rootNode = FirebaseDatabase.getInstance();
        itemDB = rootNode.getReference("Items");
        itemDB.child(aName).setValue(items).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {

                name.setText("");
                price.setText("");
                manu.setText("");
                cat.setText("");
                stock.setText("");

            }
        });
    }
}