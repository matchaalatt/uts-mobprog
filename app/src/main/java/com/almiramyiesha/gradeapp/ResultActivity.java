package com.almiramyiesha.gradeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.TextViewResult);

        Intent intent = getIntent();
        String result = "NIM: " + intent.getStringExtra("NIM") + "\n"
                + "Nama: " + intent.getStringExtra("Nama") + "\n"
                + "Semester: " + intent.getStringExtra("Semester") + "\n"
                + "Nilai Akhir: " + intent.getIntExtra("NilaiAkhir", 0) + "\n"
                + "Grade: " + intent.getStringExtra("Grade");

        textViewResult.setText(result);

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
