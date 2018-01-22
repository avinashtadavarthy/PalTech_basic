package com.example.avinash.paltech;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String patient = getIntent().getStringExtra("patient");

        TextView patientname = findViewById(R.id.patientname);

        patientname.setText(patient);

    }
}
