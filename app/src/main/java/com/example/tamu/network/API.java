package com.example.tamu.network;

import com.example.tamu.model.Tamu;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {
    @POST("tamu")
    @FormUrlEncoded
    Call<Tamu> getTamu(
@Field("nama") String nama,
@Field("alamat") String alamat,
@Field("email") String email,
@Field("tanggal") String tanggal,
@Field("keterangan") String keterangan
    );

}
