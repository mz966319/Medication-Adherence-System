package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
// import org.junit.Test;

//import static org.junit.Assert.*;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login, Register, MedProfile, MedAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Login = (Button)findViewById(R.id.BtnLogin);
        Register = (Button)findViewById(R.id.BtnRegister);
        MedProfile = (Button)findViewById(R.id.BtnAddProfile);
        MedAdd = (Button)findViewById(R.id.BtnAddMedicine);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = (EditText)findViewById(R.id.ETName);
                Password = (EditText)findViewById(R.id.ETPassword);
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                //User user = new User(username, password);
                //user.username_Empty_Validate();
                //user.password_Empty_Validate();

                Intent intent = new Intent(MainActivity.this, WelcomeUser.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    /*tmp code*/
    public void MoveToMedProfActivity(View view){
        Intent intent = new Intent(MainActivity.this, medicalProfile.class);
        startActivity(intent);
    }
    public void MoveToMedAddMedActivity(View view){
        Intent intent = new Intent(MainActivity.this, AddMedicine.class);
        startActivity(intent);
    }
    /*end of tmp code*/
}


