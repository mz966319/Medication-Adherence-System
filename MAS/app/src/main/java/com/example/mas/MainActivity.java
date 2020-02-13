package com.example.mas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
// import org.junit.Test;

//import static org.junit.Assert.*;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login, Register;
    TextView tryme;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();//.getReference();
    private DatabaseReference databaseUsers;// = database.getReference("users");
    DatabaseReference myRef;
    ListView list;
    ArrayList<String> a = new ArrayList<>();
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username = (EditText)findViewById(R.id.ETName);
        Password = (EditText)findViewById(R.id.ETPassword);
        Login = (Button)findViewById(R.id.BtnLogin);
        Register = (Button)findViewById(R.id.BtnRegister);
        tryme = (TextView) findViewById(R.id.textView55);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = Username.getText().toString();
                String password = Password.getText().toString();

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

}


