package com.almiramyiesha.gradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class resultactivity extends MainActivity {

    private TextView tvNim, tvNama, tvSemester, tvNilaiAkhir, tvGrade;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNim = findViewById(R.id.tvNim);
        tvNama = findViewById(R.id.tvNama);
        tvSemester = findViewById(R.id.tvSemester);
        tvNilaiAkhir = findViewById(R.id.tvNilaiAkhir);
        tvGrade = findViewById(R.id.tvGrade);
        btnKembali = findViewById(R.id.btnKembali);

        Intent intent = getIntent();
        String nim = intent.getStringExtra("nim");
        String nama = intent.getStringExtra("nama");
        String semester = intent.getStringExtra("semester");
        double nilaiAkhir = intent.getDoubleExtra("nilaiAkhir", 0);
        String grade = intent.getStringExtra("grade");

        tvNim.setText("NIM: " + nim);
        tvNama.setText("Nama: " + nama);
        tvSemester.setText("Semester: " + semester);
        tvNilaiAkhir.setText("Nilai Akhir: " + nilaiAkhir);
        tvGrade.setText("Grade: " + grade);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}