package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MedProfile2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_profile2);
    }
    public void MoveToCalenderActivity(View view){
        Intent intent = new Intent(MedProfile2.this, CalenderView.class);
        startActivity(intent);
    }

    public void MoveToMedActivity(View view){
        Intent intent = new Intent(MedProfile2.this, com.example.mas.AddMedicine.class);
        startActivity(intent);
    }
}
