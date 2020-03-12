package com.example.mas;

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

public class TakenHistoryPage extends AppCompatActivity {
    Button goBackButton;
    private ListView recordListView;
    ArrayList<String> recordArray = new ArrayList<>();
    ArrayAdapter<String> recordAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goBackButton = (Button) findViewById(R.id.goBackButton);
        recordListView = (ListView)findViewById(R.id.recordListView);

        //actually is ...
        myRef = database.getReference("users").child("aaa").child("record");
        //.child("medicines").child("drug1").child("record");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                MedRecord re =  dataSnapshot.getValue(MedRecord.class);
                recordArray.add(re.toString());
                recordAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, recordArray);
                recordListView.setAdapter(recordAdapter);
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
        Intent intent = new Intent(TakenHistoryPage.this, TakenPage.class);
        startActivity(intent);
    }
}
