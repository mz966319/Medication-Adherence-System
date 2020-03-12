package com.example.mas;
/**
 *<h1>login</h1>
 *
 * This activity is used to login to the app.
 *
 * @author Moaaaz Baiumy
 * @version 1.0
 * @since 2020-02-26
 */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.List;
// import org.junit.Test;

//import static org.junit.Assert.*;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login, Register;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();//.getReference();
    private DatabaseReference databaseUsers = database.getReference();
    public static final String USER = "com.example.mas.MESSAGE";
    private TextView errorMes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<User> usersList= new ArrayList<User>();

        Username = (EditText)findViewById(R.id.ETName);
        Password = (EditText)findViewById(R.id.ETPassword);
        Login = (Button)findViewById(R.id.BtnLogin);
        Register = (Button)findViewById(R.id.BtnRegister);
        errorMes = (TextView) findViewById(R.id.TVerrors);
        errorMes.setText("");
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
                for(User tryUser : usersList){
                    if(tryUser.getUsername().equals(username)){
                        if(tryUser.getPassword().equals(password)){
                            Intent intent = new Intent(MainActivity.this, WelcomeUser.class);

                            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("string_id", username);
                            editor.commit();
                            logInMessage = "Logged in successfully";
                            errorMes.setText(logInMessage);
                            startActivity(intent);

                            //Toast.makeText(MainActivity.this,"Logged in successfully", Toast.LENGTH_LONG).show();

                        }
                    }
                }
                errorMes.setText(logInMessage);
//                Toast.makeText(MainActivity.this,logInMessage, Toast.LENGTH_LONG).show();
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


