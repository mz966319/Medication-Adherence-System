package com.example.mas;
/**
 *<h1>profile medicine!</h1>
 *
 * This activity is used to display the info of each drug.
 *
 * @author Vivian Gao
 * @version 1.0
 * @since 2020-02-20
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
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
    private DatabaseReference myRef = database.getReference();
//    public static final String DRUG = "com.example.mas.MESSAGE";

    private TextView drugnameText;
    private TextView Dosage ;
    private TextView Doctorname;
    private  TextView TotalDosage;
    private TextView Frequency;
    private String drugNameee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_profile2);
          drugnameText = (TextView)findViewById(R.id.drugNameTextView);
          Dosage = (TextView)findViewById(R.id.dosageTextView);
          Doctorname = (TextView)findViewById(R.id.doctornameTextVeiw);
          TotalDosage = (TextView)findViewById(R.id.totalDosageTextView);
          Frequency = (TextView) findViewById(R.id.freqTextView);

        Intent intent = getIntent();
        final String drugname = intent.getExtras().getString("DRUG_NAME");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MedProfile2.this);
        String userName = prefs.getString("string_id", "no id");


        myRef.child("users").child(userName).child("medicines").child(drugname).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                int count =0;
                for(DataSnapshot child : children){
                    if(count==0)
                        Doctorname.setText("Doctor name: " + child.getValue(String.class));
                    if(count==1)
                        Dosage.setText("Dosage: " + child.getValue(String.class));
                    if(count==2) {
                        drugnameText.setText(" Drug name: " + child.getValue(String.class));
                        drugNameee=child.getValue(String.class);
                    }
                    if(count==3)
                        Frequency.setText("Frequency : " + child.getValue(String.class));
                    if(count==4)
                        TotalDosage.setText("Total dosage: " + child.getValue(String.class));

                    count++;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //drugnameText.setText(drugname);

    }



    public void MoveToTakenActivity(View view){
        Intent intent = new Intent(MedProfile2.this, TakenPage.class);
        intent.putExtra("DRUG",drugNameee);
        startActivity(intent);
    }

    public void MoveToMedActivity(View view){
        Intent intent = new Intent(MedProfile2.this, AddMedicine.class);
        startActivity(intent);
    }

}
