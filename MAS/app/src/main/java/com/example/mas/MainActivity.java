package com.example.mas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
// import org.junit.Test;

//import static org.junit.Assert.*;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login, Register;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();//.getReference();
    private DatabaseReference databaseUsers = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<User> usersList= new ArrayList<User>();

        Username = (EditText)findViewById(R.id.ETName);
        Password = (EditText)findViewById(R.id.ETPassword);
        Login = (Button)findViewById(R.id.BtnLogin);
        Register = (Button)findViewById(R.id.BtnRegister);
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
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String logInMessage = "Invalid username or password";
               /* for(int i = 0; i <usersList.size();i++){
                    User tryUser = usersList.get(i);*/
                for(User tryUser : usersList){
                    if(tryUser.getUsername().equals(username)){
                        if(tryUser.getPassword().equals(password)){
                            Intent intent = new Intent(MainActivity.this, WelcomeUser.class);
                            startActivity(intent);
                            logInMessage = "Logged in successfully";
                            //Toast.makeText(MainActivity.this,"Logged in successfully", Toast.LENGTH_LONG).show();

                        }
                    }
                }
                Toast.makeText(MainActivity.this,logInMessage, Toast.LENGTH_LONG).show();
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


