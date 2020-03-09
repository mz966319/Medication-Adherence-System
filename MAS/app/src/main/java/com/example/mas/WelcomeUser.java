package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class WelcomeUser extends AppCompatActivity {

    public void MoveToMainActivity(View view){
        Intent i = getIntent();
        String username = i.getStringExtra(MainActivity.USER);
        Intent intent = new Intent(WelcomeUser.this, AddMedicine.class);
        startActivity(intent);
    }


    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        TextView WelcomeTextView = (TextView) findViewById(R.id.WelcomeTextView);
        Button BtnAddMedicine = (Button) findViewById(R.id.BtnAddMedicine);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Registration.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        WelcomeTextView.setText(message);

        BtnAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToMainActivity(v);
            }
        });


    }
}