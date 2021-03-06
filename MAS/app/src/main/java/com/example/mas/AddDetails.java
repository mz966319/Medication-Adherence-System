package com.example.mas;
/**
 *<h1>Add details!</h1>
 *
 * This activity is used to added details
 *
 * @author Yurunyun Wang
 * @version 1.0
 * @since 2020-03-8
 */
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

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
                EditText TotalDosage = (EditText)findViewById(R.id.totalDosageEditText);

                String drugname = Drugname.getText().toString();
                DrugNameValidator d1 = new DrugNameValidator(drugname);
                String dosage = Dosage.getText().toString();
                DosageValidator d2 = new DosageValidator(dosage);
                String doctorname = Doctorname.getText().toString();
                DoctorNameValidator d3 = new DoctorNameValidator(doctorname);
                String totalDosage = TotalDosage.getText().toString();
                TotalDosageValidator d4 = new TotalDosageValidator(totalDosage);
                Spinner usageSpinner = (Spinner) findViewById(R.id.spinner);
                String frequency = usageSpinner.getSelectedItem().toString();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AddDetails.this);
                String userName = prefs.getString("string_id", "no id"); //no id: default value

                if(!d1.valideDrug()) {
                    Toast.makeText(AddDetails.this,"Error drug name!", Toast.LENGTH_LONG).show();
                } else if (!d2.valideDrug()) {
                    Toast.makeText(AddDetails.this,"Error dosage!", Toast.LENGTH_LONG).show();
                } else if (!d3.valideDoctor()) {
                    Toast.makeText(AddDetails.this,"Error doctor name!", Toast.LENGTH_LONG).show();
                } else if (!d4.valideTotalDosage()) {
                    Toast.makeText(AddDetails.this,"Error total dosage!", Toast.LENGTH_LONG).show();
                }else {
                    myRef = database.getReference().child("users");

                    MedicineForPatient med = new MedicineForPatient(drugname, dosage, doctorname, totalDosage, frequency);

                    myRef.child(userName).child("medicines").child(drugname).setValue(med);

//                    Toast.makeText(AddDetails.this, "Firebase connection success", Toast.LENGTH_LONG).show();

                    CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);

                    if(checkBox.isChecked()) {
                        int minute;
                        int hour;
                        Spinner hoursSpinner = (Spinner) findViewById(R.id.spinnerHours);
                        Spinner minsSpinner = (Spinner) findViewById(R.id.spinnerMins);
                        Spinner APMSpinner = (Spinner) findViewById(R.id.spinnerAPm);
                        hour = Integer.parseInt(hoursSpinner.getSelectedItem().toString());
                        minute = Integer.parseInt(minsSpinner.getSelectedItem().toString());
                        if ((APMSpinner.getSelectedItem().toString()).equals("AM")) {
                            if (hour == 12)
                                hour = 0;
                        } else if ((APMSpinner.getSelectedItem().toString()).equals("PM")) {
                            if (hour != 12)
                                hour += 12;
                        }

                        Toast.makeText(AddDetails.this, "a notification is set at " + hour + ": " + minute, Toast.LENGTH_LONG).show();


                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, hour);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, 0);

                        Intent notificationIntent = new Intent(getApplicationContext(), NotificationReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                    }





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
                "Just Once", "Everyday", "Every Two Days", "Every Week", "Every Month"};
        Spinner usageSpinner = (Spinner) findViewById(R.id.spinner);
//        usageSpinner.setPrompt("Usage Period");
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

        String[] arraySpinnerMins= new String[60];
        for(int i=0;i<=59;i++){
            arraySpinnerMins[i]=Integer.toString((i));
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
