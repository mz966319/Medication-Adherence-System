package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddDetails extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("medicines");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        Button button = (Button)findViewById(R.id.saveDrug);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Drugname = (EditText)findViewById(R.id.drugName);
                EditText Dosage = (EditText)findViewById(R.id.dosage);
                EditText Doctorname = (EditText)findViewById(R.id.doctorName);

                String drugname = Drugname.getText().toString();
                DrugNameValidator d1 = new DrugNameValidator(drugname);
                String dosage = Drugname.getText().toString();
                DosageValidator d2 = new DosageValidator(drugname);
                String doctorname = Drugname.getText().toString();
                DoctorNameValidator d3 = new DoctorNameValidator(doctorname);

                if(!d1.valideDrug()) {
                    Toast.makeText(AddDetails.this,"Error drug name!", Toast.LENGTH_LONG).show();
                } else if (!d2.valideDrug()) {
                    Toast.makeText(AddDetails.this,"Error dosage!", Toast.LENGTH_LONG).show();
                } else if (!d3.valideDoctor()) {
                    Toast.makeText(AddDetails.this,"Error doctor name!", Toast.LENGTH_LONG).show();
                } else {
                    myRef = database.getReference().child("medicines");

                    myRef.child(drugname).child("drugname").setValue(drugname);
                    myRef.child(drugname).child("dosage").setValue(dosage);
                    myRef.child(drugname).child("doctorname").setValue(doctorname);

                    Toast.makeText(AddDetails.this, "Firebase connection success", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(AddDetails.this, AddMedicine.class);
                    startActivity(intent);
                }
            }
        });
    }
}
