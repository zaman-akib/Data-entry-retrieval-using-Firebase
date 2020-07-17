package com.example.online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;
import java.sql.Time;

public class InputActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    DatabaseReference databaseReference;
    EditText read_et,time,date;
    Button submit_bt;
    Spinner spinner;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        setTitle("Input Glucose");

        String[] level = { "Random", "Fasting", "After meal"};

        databaseReference = FirebaseDatabase.getInstance().getReference("Glucose");

        read_et=findViewById(R.id.reading_et);
        time=findViewById(R.id.time);
        date=findViewById(R.id.date);
        submit_bt=findViewById(R.id.submit_bt);
        spinner=findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,level);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = databaseReference.push().getKey();

                if(read_et.getText().toString().isEmpty() || time.getText().toString().isEmpty()|| date.getText().toString().isEmpty()){
                    Toast.makeText(InputActivity.this,"Please insert value in every field",Toast.LENGTH_SHORT).show();
                    return;
                }

                Data data = new Data(read_et.getText().toString(),type,time.getText().toString(),date.getText().toString());

                databaseReference.child(key).setValue(data);

                Toast.makeText(InputActivity.this,"Data is stored",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                type="Random";
                break;
            case 1:
                type="Fasting";
                break;
            case 2:
                type="After meal";
                break;
            default:
                type="Random";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
