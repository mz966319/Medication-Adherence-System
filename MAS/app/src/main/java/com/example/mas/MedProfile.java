package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class MedProfile extends AppCompatActivity {

//public class MedProfile extends AppCompatActivity {

    public void MoveToCalenderActivity(View view){
        Intent intent = new Intent(MedProfile.this, CalenderView.class);
        startActivity(intent);
    }

    public void MoveToMedActivity(View view){
        Intent intent = new Intent(MedProfile.this, AddMedicine.class);
        startActivity(intent);
    }
    TextView MedNameTextView;
    ScrollView MedInfoScrollView;
    Button ShowCalenderBt,RecordTakenBt,BackBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_profile);
//        TextView MedNameTextView = (TextView) findViewById(R.id.MedNameTextView);
//        ScrollView MedInfoScrollView = (ScrollView) findViewById(R.id.MedInfoScrollView);
//          Button ShowCalenderBt = (Button) findViewById(R.id.ShowCalenderBt);
//          Button RecordTakenBt = (Button) findViewById(R.id.RecordTakenBt);

        ShowCalenderBt = (Button) findViewById(R.id.ShowCalenderBt);
        ShowCalenderBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToCalenderActivity(v);
            }
        });

        BackBt = (Button) findViewById(R.id.BackBt);
        BackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToMedActivity(v);
            }
        });
    }

}

