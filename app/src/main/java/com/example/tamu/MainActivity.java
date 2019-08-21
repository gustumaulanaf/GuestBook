package com.example.tamu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton btTangal;
    Button btSubmit;
    EditText nama,email,tanggal,keterangan;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateformatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     btTangal = findViewById(R.id.btDate);
     tanggal = findViewById(R.id.etTanggal);
     nama  = findViewById(R.id.etNama);
     email = findViewById(R.id.etEmail);
     keterangan = findViewById(R.id.etKeterangan);
        btTangal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showDatePicker();
            }
        });
        btSubmit = findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nama.getText())){
                    nama.setError("Tidak Boleh Kosong !");
                }
                else if (TextUtils.isEmpty(email.getText())){
                    email.setError("Tidak Boleh Kosong !");
                }
                else  if (TextUtils.isEmpty(tanggal.getText())){
                    tanggal.setError("Tidak Boleh Kosong !");
                }
                else if (TextUtils.isEmpty(keterangan.getText())){
                    keterangan.setError("Tidak Boleh Kosong !");
                }
                else {
                    startActivity(new Intent(MainActivity.this, DoneActivity.class));
                    finish();
                }
            }
        });

    }
    void showDatePicker(){
        final Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String formatTanggal = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(newCalendar.getTime());

                tanggal.setText(formatTanggal);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
