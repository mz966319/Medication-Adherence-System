package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection success", Toast.LENGTH_LONG).show();
    }
    /*tmp code*/
    public void MoveToMedProfActivity(View view){
        Intent intent = new Intent(MainActivity.this, medicalProfile.class);
        startActivity(intent);
    }
    /*public void MoveToMedAddMedActivity(View view){
        Intent intent = new Intent(MainActivity.this, AddMedicine.class);
        startActivity(intent);
    }*/
    /*end of tmp code*/
}
