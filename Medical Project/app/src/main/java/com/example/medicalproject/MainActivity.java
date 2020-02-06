package com.example.medicalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseMedProj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ShowCalenderBt = (Button) findViewById(R.id.ShowCalenderBt);
        ShowCalenderBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseMedProj = FirebaseDatabase.getInstance().getReference();

                TextView MedNameTextView = (TextView) findViewById(R.id.MedNameTextView);
                ScrollView MedInfoScrollView = (ScrollView) findViewById(R.id.MedInfoScrollView);


            }
        });
    }
}
