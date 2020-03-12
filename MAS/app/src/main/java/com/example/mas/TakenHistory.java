package com.example.mas;

/**
 *<h1>Add taken history</h1>
 *
 * This activity is used list record taken drug.
 *
 * @author Yurunyun Wang
 * @version 1.0
 * @since 2020-03-20
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//acutally this is 'TakenHistory' class
public class TakenHistory extends AppCompatActivity {
    Button goBackButton;
    private ListView recordListView;
    ArrayList<String> recordArray = new ArrayList<>();
    ArrayAdapter<String> recordAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taken_history);
        goBackButton = (Button) findViewById(R.id.goBackButton);
        recordListView = (ListView)findViewById(R.id.recordListView);

        Intent intent = getIntent();
        String username = intent.getStringExtra(TakenPage.USERNAME);
        String drugname = intent.getStringExtra(TakenPage.MEDNAME);
//        startActivity(intent);

        //actually is ...
        myRef = database.getReference("users").child("aaa").child("record");
        //myRef = database.getReference("users").child("aaa").child("record");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MedRecord re =  dataSnapshot.getValue(MedRecord.class);
                recordArray.add(re.toString());
                recordAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, recordArray);
                recordListView.setAdapter(recordAdapter);
                recordAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }//end of onCreate method

    public void clickOnBack(View view){
        Intent intent = new Intent(TakenHistory.this, TakenPage.class);
//        Intent intent = new Intent(TakenHistory.this, TakenPage.class);
        startActivity(intent);
    }
}
