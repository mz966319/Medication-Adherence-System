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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.R.layout.*;

/**
 *<h1>Dosage Left!</h1>
 * Activity for loading left dosage for all the medicine under a specific user
 *
 * This activity is used to display different amount of dosage left for various medicine from the current date.
 *
 * @author Vivian Gao
 * @version 1.0
 * @since 2020-03-10
 */
public class DosageLeft extends AppCompatActivity {

    public final static String USERNAME = "Username";//grab the current user name from previous page

    private TextView invalidPreferredUserName;
    private TextView invalidEmailAddress;
    private ListView mListView;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();

    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> finalList  = new ArrayList<>();//contains the final printed list
//    private final ArrayList<MedicineForPatient> medicineList = new ArrayList<>();

    private int datePointer=0;//points to the current index in the arraylist which contains dates
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_left);

        final ArrayList<MedicineForPatient> medicineList = new ArrayList<>();
        medicineList.add(new MedicineForPatient("aDrug","10", "David", "10","Just Once"));
//        medicineList.add(new MedicineForPatient("bDrug","3", "David", "6","Everyday"));
//        medicineList.add(new MedicineForPatient("cDrug","5", "David", "20","Every Two Days"));
//        medicineList.add(new MedicineForPatient("dDrug","5", "David", "20","Every Week"));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(DosageLeft.this);
        String userName = prefs.getString("string_id", "no id"); //no id: default value

        final ListView mListView = (ListView) findViewById(R.id.listview);
        Calendar c = Calendar.getInstance();
        Date today = c.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        finalList.add(dateFormat.format(today));
        int daysUntilFinish = 0;
//
//        // [START read_message]
//        // Read from the database`

        ref.child("users").child(userName).child("medicine").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot child : children) {
                    MedicineForPatient medicineForPatient = child.getValue(MedicineForPatient.class);
//                    (String drugName, String dosage, String doctorname, String totalDosage, String frequency)
//                    MedicineForPatient medicineForPatient =
//                            new MedicineForPatient((child.getValue(MedicineForPatient.class)).getDrugName(),(child.getValue(MedicineForPatient.class)).getDosage(),
//                                    (child.getValue(MedicineForPatient.class)).getDoctorname(),(child.getValue(MedicineForPatient.class)).getTotalDosage(),(child.getValue(MedicineForPatient.class)).getFrequency());

                    medicineList.add(medicineForPatient); // add all medicine into one list
//                    User user = child.getValue(User.class);
//                    usersList.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



//if (medicineList.size()!=0){
        int timesUntilFinish = Integer.parseInt(medicineList.get(0).getTotalDosage()) / Integer.parseInt(medicineList.get(0).getDosage());

        daysUntilFinish = (timesUntilFinish - 1) * ConvertFrequencyToNumber(medicineList.get(0));

        for (int i = 0; i < medicineList.size(); i++) { //get the total dates that should show on canlender
            timesUntilFinish = Integer.parseInt(medicineList.get(i).getTotalDosage()) / Integer.parseInt(medicineList.get(i).getDosage());

            if (daysUntilFinish < (timesUntilFinish - 1) * ConvertFrequencyToNumber(medicineList.get(i))) {
                daysUntilFinish = (timesUntilFinish - 1) * ConvertFrequencyToNumber(medicineList.get(i));
            }
        }

        for (int i = 1; i < daysUntilFinish; i++) {
            c.add(Calendar.DATE, 1);
            Date future = c.getTime();
            finalList.add(dateFormat.format(future));
        }

        for (int i = 0; i < medicineList.size(); i++) {//for each medicine
            int medicineTokenFrequency = ConvertFrequencyToNumber(medicineList.get(i));
            for (int j = 0; j < daysUntilFinish; j = j + medicineTokenFrequency) {
                int dosageLeft = Integer.parseInt(medicineList.get(i).getTotalDosage()) - Integer.parseInt(medicineList.get(i).getDosage());
                if (dosageLeft > 0) {
                    finalList.set(j, finalList.get(j) + "\t\t" + medicineList.get(i).getDrugName() + ": " + dosageLeft);
                    medicineList.get(i).setTotalDosage("" + dosageLeft);
                }
                if (dosageLeft == 0) {
                    finalList.set(j, finalList.get(j) + "\t\t" + medicineList.get(i).getDrugName() + ": " + dosageLeft);
                    medicineList.get(i).setTotalDosage("" + dosageLeft);
                    break;
                }

            }
        }

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), simple_list_item_1, finalList);
        arrayAdapter.notifyDataSetChanged();
        mListView.setAdapter(arrayAdapter);

    }
//    }
    protected int ConvertFrequencyToNumber (MedicineForPatient medicineForPatient){//enter the date to final list first
        int frequency =0;
        if (medicineForPatient.getFrequency().equals("Just Once"))
            frequency=0;
        else if (medicineForPatient.getFrequency().equals("Everyday"))
            frequency = 1;
        else if (medicineForPatient.getFrequency().equals("Every Two Days"))
            frequency = 2;
        else if (medicineForPatient.getFrequency().equals("Every Week"))
            frequency = 7;
        else if (medicineForPatient.getFrequency().equals("Every Month"))
            frequency = 30;


        return frequency;
    }
}
