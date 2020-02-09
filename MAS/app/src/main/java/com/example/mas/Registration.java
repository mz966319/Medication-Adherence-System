package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {


    EditText Fullname, Username, Password;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Fullname = (EditText)findViewById(R.id.ETFullname);
        Username = (EditText)findViewById(R.id.ETUsername);
        Password = (EditText)findViewById(R.id.ETPassword);
        Register = (Button)findViewById(R.id.BtnRegister);

    Register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Registration.this, MainActivity.class);
            startActivity(intent);
        }
    });
    }
}
