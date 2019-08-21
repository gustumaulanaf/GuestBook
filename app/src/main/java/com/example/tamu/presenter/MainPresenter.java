package com.example.tamu.presenter;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.tamu.interfaces.MainView;
import com.example.tamu.model.Tamu;
import com.example.tamu.network.BaseUrl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
MainView mainView;
BaseUrl baseUrl;
ProgressDialog progressDialog;
Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        if (baseUrl==null){
            this.baseUrl = new BaseUrl();
        }
    }
  public   void addData(String nama , String email, String alamat ,String tanggal ,String keterangan ){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Tunggu");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        baseUrl.getAPI().getTamu(nama,alamat,email,tanggal,keterangan).enqueue(new Callback<Tamu>() {
            @Override
            public void onResponse(Call<Tamu> call, Response<Tamu> response) {
                if (response.isSuccessful()){
                    mainView._onLoading();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Tamu> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}
