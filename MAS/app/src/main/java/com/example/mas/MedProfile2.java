package com.example.mas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MedProfile2 extends AppCompatActivity {
    private FirebaseDatabase  database = FirebaseDatabase.getInstance();//.getReference();
    private DatabaseReference myRef;// = database.getReference();
    ArrayList<MedicineForPatient> a = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_profile2);
         TextView drugnameText = (TextView)findViewById(R.id.drugNameTextView);
//        TextView Dosage = (TextView)findViewById(R.id.dosageTextView);
//        TextView Doctorname = (TextView)findViewById(R.id.doctornameTextVeiw);
//        TextView TotalDosage = (TextView)findViewById(R.id.totalDosageTextView);

        Intent intent = getIntent();
        final String drugname = intent.getExtras().getString("DRUG_NAME");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MedProfile2.this);
        String userName = prefs.getString("string_id", "no id");

        drugnameText.setText(drugname);


//        myRef = database.getReference().child("users").child(userName).child("medicines");
//
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                MedicineForPatient med = dataSnapshot.getValue(MedicineForPatient.class);
//                a.add(med);
//            }
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//            }
//        });
//        drugnameText.setText(a.get(0).getTotalDosage());

    }




    public void MoveToCalenderActivity(View view){
        Intent intent = new Intent(MedProfile2.this, CalenderView.class);
        startActivity(intent);
    }

    public void MoveToMedActivity(View view){
        Intent intent = new Intent(MedProfile2.this, AddMedicine.class);
        startActivity(intent);
    }
}
