package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalenderView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);
    }
    public void MoveToMedActivity(View view){
        Intent intent = new Intent(CalenderView.this, MedProfile2.class);
        startActivity(intent);
    }
}
