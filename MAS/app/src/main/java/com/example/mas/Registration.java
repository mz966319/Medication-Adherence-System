package com.example.mas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

//import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.testProject.MESSAGE";
    private static final String USER = "com.example.a2.MESSAGE";

    private FirebaseDatabase  database = FirebaseDatabase.getInstance();//.getReference();
    private DatabaseReference databaseUsers = database.getReference("users");
    //DatabaseReference ref = databaseUsers.getRef("server/saving-data/fireblog");


    //EditText Fullname, Username, Password;
   // Button Register;

//    DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final List<User> usersList= new ArrayList<User>();
        final EditText Fullname = (EditText) findViewById(R.id.ETFullname);
        final EditText Username = (EditText) findViewById(R.id.ETUsername);
        final EditText Password = (EditText) findViewById(R.id.ETPassword);
        final Button Register = (Button) findViewById(R.id.BtnRegister);

        databaseUsers.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot child : children){
                    User user = child.getValue(User.class);
                    usersList.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String fullname = Fullname.getText().toString();

                User user = new User(username, password, fullname);
                if(!user.username_Empty_Validate()){
                    //Toast.makeText(this,"Empty username!",Toast.LENGTH_LONG).show();
                }
                else if (!user.password_Empty_Validate()){
                    //Toast.makeText(this,"Empty password!",Toast.LENGTH_LONG).show();
                }
                else if (!user.fullname_Empty_Validate()){
                    //Toast.makeText(this,"Empty full name!",Toast.LENGTH_LONG).show();
                }
                else {

                    databaseUsers = database.getReference().child("users");
                    databaseUsers.child(username).setValue(user);
                    Toast.makeText(Registration.this,"Registration done!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registration.this, WelcomeUser.class);
                    startActivity(intent);
                }
            }
        });
    }

    /*public void RigisterButtonClicked(View view) {
        Fullname = (EditText) findViewById(R.id.ETFullname);
        Username = (EditText) findViewById(R.id.ETUsername);
        Password = (EditText) findViewById(R.id.ETPassword);

        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String fullname = Fullname.getText().toString();

        User user = new User(username, password, fullname);
        if(!user.username_Empty_Validate()){
            Toast.makeText(this,"Empty username!",Toast.LENGTH_LONG).show();
        }
        else if (!user.password_Empty_Validate()){
            Toast.makeText(this,"Empty password!",Toast.LENGTH_LONG).show();
        }
        else if (!user.fullname_Empty_Validate()){
            Toast.makeText(this,"Empty full name!",Toast.LENGTH_LONG).show();
        }
        else {
            databaseUsers = database.getReference().child("users");
            databaseUsers.child(username).setValue(user);
            Toast.makeText(Registration.this,"Registration done!!!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Registration.this, WelcomeUser.class);
            startActivity(intent);
        }
    }*/

}
