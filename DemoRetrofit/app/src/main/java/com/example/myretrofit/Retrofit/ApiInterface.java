package com.example.myretrofit.Retrofit;

import com.example.myretrofit.Models.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("dangnhap.php")
    Call<List<StudentModel>> loginUser(@Field("SODIENTHOAI") String SODIENTHOAI
                                 ,@Field("MATKHAU")String MATKHAU);

}
