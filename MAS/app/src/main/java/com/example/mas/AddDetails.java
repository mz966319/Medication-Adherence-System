package com.example.mas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

        CreateSpinners();
        LinearLayout notificationLayout = (LinearLayout) findViewById(R.id.notificationLayout);

        notificationLayout.setVisibility(View.INVISIBLE);

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
                   Medicine med = new Medicine(drugname, dosage, doctorname);
                   myRef.child(drugname).setValue(med);
//                    myRef.child(drugname).child("drugname").setValue(drugname);
//                    myRef.child(drugname).child("dosage").setValue(dosage);
//                    myRef.child(drugname).child("doctorname").setValue(doctorname);

                    Toast.makeText(AddDetails.this, "Firebase connection success", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(AddDetails.this, AddMedicine.class);
                    startActivity(intent);
                }
            }
        });
    }



    public void setShowNotificationOptions(View view){
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        LinearLayout notificationLayout = (LinearLayout) findViewById(R.id.notificationLayout);

        if(checkBox.isChecked()){
            notificationLayout.setVisibility(View.VISIBLE);
        }
        if(!checkBox.isChecked()){
            notificationLayout.setVisibility(View.INVISIBLE);
        }
    }



    private void CreateSpinners(){
        String[] arraySpinnerUsage = new String[] {
                "Just Once", "Everyday", "Odd Days", "Even Days", "Every Week", "Every Month"};
        Spinner usageSpinner = (Spinner) findViewById(R.id.spinner);
        usageSpinner.setPrompt("Usage Period");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerUsage);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        usageSpinner.setAdapter(adapter);

        String[] arraySpinnerHours = new String[] {
                "1", "2", "3", "4", "5", "6","7","8","9","10","11","12"};
        Spinner hoursSpinner = (Spinner) findViewById(R.id.spinnerHours);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerHours);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hoursSpinner.setAdapter(adapter);

        String[] arraySpinnerMins= new String[59];
        for(int i=0;i<59;i++){
            arraySpinnerMins[i]=Integer.toString((i+1));
        }
        Spinner minsSpinner = (Spinner) findViewById(R.id.spinnerMins);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerMins);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minsSpinner.setAdapter(adapter);

        String[] arraySpinnerAPM = new String[] {"AM", "PM"};
        Spinner APMSpinner = (Spinner) findViewById(R.id.spinnerAPm);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerAPM);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        APMSpinner.setAdapter(adapter);
    }
}
