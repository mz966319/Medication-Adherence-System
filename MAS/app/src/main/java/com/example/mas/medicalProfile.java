package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class medicalProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_profile);

        Button ShowCalenderBt = (Button) findViewById(R.id.ShowCalenderBt);
        ShowCalenderBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                TextView MedNameTextView = (TextView) findViewById(R.id.MedNameTextView);
                ScrollView MedInfoScrollView = (ScrollView) findViewById(R.id.MedInfoScrollView);


            }
        });
    }

}
