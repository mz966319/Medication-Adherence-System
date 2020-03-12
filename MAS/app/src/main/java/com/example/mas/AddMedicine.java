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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.mas.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddMedicine extends AppCompatActivity {

    ListView list;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    ArrayList<String> a = new ArrayList<>();
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        myRef = FirebaseDatabase.getInstance().getReference("medicines");
        list = (ListView)findViewById(R.id.list);
        myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, a);
        list.setAdapter(myadapter);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AddMedicine.this);
        String userName = prefs.getString("string_id", "no id");

        myRef = database.getReference().child("users").child(userName).child("medicines");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String drugname = dataSnapshot.getKey();
                a.add(drugname);
                myadapter.notifyDataSetChanged();

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
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent intent = new Intent(AddMedicine.this, MedProfile2.class);
                intent.putExtra("DRUG_NAME", a.get(position));
                startActivity(intent);
            }
        });

    }
    public void openNew(View view) {
        Intent intent = new Intent(AddMedicine.this, AddDetails.class);
        startActivity(intent);
    }



}