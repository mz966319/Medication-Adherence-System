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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {


    EditText Fullname, Username, Password;
    Button Register;

//    DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("Users");

    //ArrayList<String> arrayList = new ArrayList<>();
    //ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//        databaseUsers = FirebaseDatabase.getInstance().getReference("Users");
        //arrayAdapter = new ArrayAdapter<String>(this,and)
        final DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
        Register = (Button)findViewById(R.id.BtnRegister);
        Fullname = (EditText)findViewById(R.id.ETFullname);
        Username = (EditText)findViewById(R.id.ETUsername);
        Password = (EditText)findViewById(R.id.ETPassword);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = Fullname.getText().toString();
                String un = Username.getText().toString();
                String psw = Password.getText().toString();

                User user = new User(un, psw, fn);

                mRoot.push().setValue(user);
            }
            });

            /*String username, password, fullname;
            username = Username.getText().toString();
            password = Password.getText().toString();
            fullname = Fullname.getText().toString();

            User user = new User(username, password, fullname);

            if(user.username_Empty_Validate() && user.password_Empty_Validate() && user.fullname_Empty_Validate()){

                databaseUsers.child(user.getUsername()).setValue(user);

                Intent intent = new Intent(Registration.this, WelcomeUser.class);
                startActivity(intent);
            }
        }
    });*/
    }
//    public void RigisterButtonClicked(View view){
//        Fullname = (EditText)findViewById(R.id.ETFullname);
//        Username = (EditText)findViewById(R.id.ETUsername);
//        Password = (EditText)findViewById(R.id.ETPassword);
//        Register = (Button)findViewById(R.id.BtnRegister);
//
//            String username, password, fullname;
//            username = Username.getText().toString();
//            password = Password.getText().toString();
//            fullname = Fullname.getText().toString();
//
//            User user = new User(username, password, fullname);
//
//            Map<String,String> map = new HashMap<String,String>();
//            map.put("Name","Mark");
//
//            FirebaseFirestore database = FirebaseFirestore.getInstance();
//            //DocumentReference myRef = database.document();
//            database.collection("MyCollection").add(map);
//            /*myRef = database.getReference("/data/test");
//
//            myRef.setValue("Hello, World!");*/
//
//            if(user.username_Empty_Validate() && user.password_Empty_Validate() && user.fullname_Empty_Validate()){
//
//                //database.setValue(user);
////                databaseUsers.child("users").setValue(user);
////                DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("Users");
////
////                databaseUsers.setValue(username);
//                // Write a message to the database
//
//
//                Intent intent = new Intent(Registration.this, WelcomeUser.class);
//                startActivity(intent);
//            }
//    }


    /*private Boolean fullname_validation() {

        String fullname = Fullname.getText().toString();
        if (fullname.isEmpty()) {
            Toast.makeText(this, "Please enter your fullname", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private Boolean username_validation() {

        String username = Username.getText().toString();
        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter your username address", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Preferred_PATTERN.matcher(username).matches()) {
            Toast.makeText(this, "Your username should be at least 6 characters", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }*/

    /*private Boolean password_validation(){
        String password = Password.getText().toString();
        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Preferred_PATTERN.matcher(password).matches()) {
            Toast.makeText(this, "Your password should be at least 6 characters", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }*/
}