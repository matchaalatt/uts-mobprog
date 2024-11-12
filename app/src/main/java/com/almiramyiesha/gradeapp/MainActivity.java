package com.almiramyiesha.gradeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNim, etNama, etPresensi, etTugas, etUTS, etUAS;
    private RadioGroup rgSemester;
    private RadioButton rbGasal, rbGenap;
    private Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNamaLengkap);
        etPresensi = findViewById(R.id.etPresensi);
        etTugas = findViewById(R.id.etTugas);
        etUTS = findViewById(R.id.etUTS);
        etUAS = findViewById(R.id.etUAS);
        rbGasal = findViewById(R.id.rbGasal);
        rbGenap = findViewById(R.id.rbGenap);
        btnHitung = findViewById(R.id.btnHitungNilaiAkhir);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungNilaiAkhir();
            }
        });
    }

    private void hitungNilaiAkhir() {
        String nim = etNim.getText().toString();
        String nama = etNama.getText().toString();
        String presensiStr = etPresensi.getText().toString();
        String tugasStr = etTugas.getText().toString();
        String utsStr = etUTS.getText().toString();
        String uasStr = etUAS.getText().toString();

        if (nim.isEmpty() || nama.isEmpty() || presensiStr.isEmpty() || tugasStr.isEmpty() || utsStr.isEmpty() || uasStr.isEmpty()) {
            Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show();
            return;
        }

        double presensi = Double.parseDouble(presensiStr);
        double tugas = Double.parseDouble(tugasStr);
        double uts = Double.parseDouble(utsStr);
        double uas = Double.parseDouble(uasStr);

        double nilaiAkhir = (0.1 * presensi) + (0.2 * tugas) + (0.3 * uts) + (0.4 * uas);
        String grade;

        if (nilaiAkhir >= 85) {
            grade = "A";
        } else if (nilaiAkhir >= 70) {
            grade = "B";
        } else if (nilaiAkhir >= 55) {
            grade = "C";
        } else if (nilaiAkhir >= 40) {
            grade = "D";
        } else {
            grade = "E";
        }

        int selectedSemesterId = rgSemester.getCheckedRadioButtonId();
        String semester = selectedSemesterId == R.id.rbGasal ? "Gasal" : "Genap";

        Intent intent = new Intent(MainActivity.this, resultactivity.class);
        intent.putExtra("nim", nim);
        intent.putExtra("nama", nama);
        intent.putExtra("semester", semester);
        intent.putExtra("nilaiAkhir", nilaiAkhir);
        intent.putExtra("grade", grade);
        startActivity(intent);
    }
}