package com.example.mas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
/**
 *<h1>Add taken page</h1>
 *
 * This activity is used to let user record taken drug.
 *
 * @author Yurunyun Wang
 * @version 1.0
 * @since 2020-03-20
 */
//this is the page to ask user whether they want to record a dosage
public class TakenPage extends AppCompatActivity {
    public final static String USERNAME = "username";
    public final static String MEDNAME = "medname";

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    DatabaseReference myR;
    Button takenButton;
    Button cancelButton;
    Button takenHistoryButton;
private String medname;


//    String medname = "drug1";
    String dosage;////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken_page);
        takenButton = (Button) findViewById(R.id.takenButton);
//        cancelButton = (Button) findViewById(R.id.cancelButton);
        takenHistoryButton = (Button) findViewById(R.id.takenHistoryButton);

        Intent i = getIntent();
         medname =i.getExtras().getString("DRUG");
    }

    public void clickOnTaken(View view){
//
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(TakenPage.this);
        String username = prefs.getString("string_id", "no id"); //no id: default value

        Toast.makeText(TakenPage.this, username+" "+medname, Toast.LENGTH_LONG).show();

//        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/DD HH:mm");
//        Date curDate = new Date(System.currentTimeMillis());
//        String dateStr = formatter.format(curDate);
//        Toast.makeText(TakenPage.this, dateStr + "   Record success!"+username+" "+medname, Toast.LENGTH_LONG).show();

//        SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY/MM/DD");
//        Date curDate2 = new Date(System.currentTimeMillis());
//        String onlyDateStr = formatter2.format(curDate2);

//        myRef = db.getReference().child("users").child(username).child("medicines").child(medname).child("dosage");
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                String dosageQ = dataSnapshot.getKey();
//                String dosageQQ = dataSnapshot.child("dosage").getKey();
//                dosage = dosageQ;
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        MedRecord r;

        //create MedRecord Obj
        dosage = "10";//////////
        r = new MedRecord();
        r.setUsername(username);
        r.setMed_name(medname);
//        r.setDate(onlyDateStr);
        r.setDate("d2dd");
        r.setTakenStatus(true);
        r.setQuantity(dosage);

//        write record to db
        myR = db.getReference().child("users").child(username).child("record");
        String s1 = db.getReference().child("users").child(username).push().getKey();
        myR.child(s1).setValue(r);

        //go to Taken List Page and send username and med name
        Intent intent = new Intent(TakenPage.this, TakenHistory.class);
        intent.putExtra(TakenPage.USERNAME, r.getUsername());
        intent.putExtra(TakenPage.MEDNAME, r.getMed_name());
        startActivity(intent);
    }

    //button for 'record later' :  go back to the medicine profile
    public void clickOnCancel(View view){
        Intent intent = new Intent(TakenPage.this, MedProfile2.class );
        //should be change as below
//        Intent intent = new Intent(TakenPage.this, MedProfile2.class );
        startActivity(intent);
    }

    public void clickOnTakenHis(View view){
        Intent intent = new Intent(TakenPage.this, TakenHistory.class);
//      Intent intent = new Intent(TakenPage.this, TakenHistory.class);
        startActivity(intent);
    }
}
