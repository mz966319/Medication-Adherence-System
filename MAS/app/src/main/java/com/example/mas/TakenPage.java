package com.example.mas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Intent;
import android.os.Bundle;
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

//this is the page to ask user whether they want to record a dosage
public class TakenPage extends AppCompatActivity {
    //    public final static String USER_NAME = "username";////////
//    public final static String MED_NAME = "medname";////////
//       String username = intent.getStringExtra(MedProfileActivity.USER_NAME);
//        String drugname = intent.getStringExtra(MedProfileActivity.MED_NAME);
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    DatabaseReference myR;

    //need to be sent a username from MedProfilePage(delete after modify)
    String username = "aaa";
    String medname = "drug1";
    String dosage;////////////

    Button takenButton;
    Button cancelButton;
    Button takenHistoryButton;
    MedRecord r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken_page);
        takenButton = (Button) findViewById(R.id.takenButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        takenHistoryButton = (Button) findViewById(R.id.takenHistoryButton);
    }

    public void clickOnTaken(View view){
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/DD  HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        String dateStr = formatter.format(curDate);
        Toast.makeText(TakenPage.this, dateStr + "   Record success!", Toast.LENGTH_LONG).show();

        SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY/MM/DD");
        Date curDate2 = new Date(System.currentTimeMillis());
        String onlyDateStr = formatter2.format(curDate2);

        /*db*/
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

        //create MedRecord Obj
        dosage = "10";//////////
        r = new MedRecord();
        r.setUsername(username);
        r.setMed_name(medname);
        r.setDate(onlyDateStr);
        r.setTakenStatus(true);
        r.setQuantity(dosage);

        //write record to db
        myR = db.getReference().child("users").child(username).child("record");
        String s1 = db.getReference().child("users").child(username).push().getKey();
        myR.child(s1).setValue(r);

        //go to Taken List Page and send username and med name
        Intent intent = new Intent(TakenPage.this, TakenHistoryPage.class);
//        intent.putExtra(TakenPage.USER_NAME, r.getUsername());//actually is taken list activity
//        intent.putExtra(TakenPage.MED_NAME, r.getMed_name());//actually is taken list activity
        startActivity(intent);
    }

    //button for 'record later' :  go back to the medicine profile
    public void clickOnCancel(View view){
        Intent intent = new Intent(TakenPage.this, MedProfile2.class );
        //should be change as below
//        Intent intent = new Intent(TakenPage.this, MedProfile.class );
        startActivity(intent);
    }

    public void clickOnTakenHis(View view){
        Intent intent = new Intent(TakenPage.this, TakenHistoryPage.class);
        startActivity(intent);
    }
}
