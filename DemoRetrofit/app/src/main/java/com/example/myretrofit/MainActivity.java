package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myretrofit.Models.StudentModel;
import com.example.myretrofit.Retrofit.ApiInterface;
import com.example.myretrofit.Retrofit.Retrofitclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText txtTaiKhoan,txtMatKhau;
    Button btnDangKi,btnDangNhap;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        apiInterface= Retrofitclient.getClient().create(ApiInterface.class);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              loginUser(v);
          }
      });
    }


    private void AnhXa()
    {
        txtTaiKhoan=findViewById(R.id.txtTaiKhoan);
        txtMatKhau=findViewById(R.id.txtMatKHau);
        btnDangKi=findViewById(R.id.btnDangKi);
        btnDangNhap=findViewById(R.id.btnDangNhap);
    }

    public void loginUser(View v)
    {
        Call<List<StudentModel>> studentModelCall=apiInterface.loginUser(txtTaiKhoan.getText().toString(),
                txtMatKhau.getText().toString());
        studentModelCall.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                if(response.body().size()!=0)
                {
                    //Code xử lý lấy thông tin về tài khoản
                    // khi response trả về một mảng các StudentModel
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registerUser(View v)
    {
        Intent intent= new Intent(MainActivity.this,DangKiActivity.class);
        startActivity(intent);
    }


}