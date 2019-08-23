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

import com.example.tamu.interfaces.MainView;
import com.example.tamu.presenter.MainPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainView {
    ImageButton btTangal;
    Button btSubmit;
    EditText ETnama,ETemail,ETketerangan,ETalamat;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter  = new MainPresenter(this);
        mainPresenter.setContext(this);
     ETnama  = findViewById(R.id.etNama);
     ETemail = findViewById(R.id.etEmail);
     ETalamat = findViewById(R.id.etAlamat);
     ETketerangan = findViewById(R.id.etKeterangan);
        btSubmit = findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(ETnama.getText())){
                    ETnama.setError("Tidak Boleh Kosong !");
                }
                else if (TextUtils.isEmpty(ETemail.getText())){
                    ETemail.setError("Tidak Boleh Kosong !");
                }
                else if (TextUtils.isEmpty(ETketerangan.getText())){
                    ETketerangan.setError("Tidak Boleh Kosong !");
                }
                else {
                    String nama,alamat,tanggal,email,keterangan;
                    nama = ETnama.getText().toString();
                    alamat=ETalamat.getText().toString();
                    email=ETemail.getText().toString();
                    keterangan=ETketerangan.getText().toString();
                    mainPresenter.addData(nama,email,alamat,keterangan);
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void _onLoading() {
        startActivity(new Intent(MainActivity.this,DoneActivity.class));
        finish();
    }
}
