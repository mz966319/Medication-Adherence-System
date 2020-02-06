package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



public class AddMedicine extends AppCompatActivity {

    ListView theListView;
    Intent myIntent;

    private Button AdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        theListView = (ListView) findViewById(R.id.myListView);
        String[ ] myData = {"A","B","C"};
        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myData);
        theListView.setAdapter(myAdapter);

    }

    public void MoveToActivityTwo(View view){
        Intent intent = new Intent(AddMedicine.this, AdDetails.class);
        startActivity(intent);
    }
}
