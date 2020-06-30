package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DangKiActivity extends AppCompatActivity {
    EditText txtTaiKhoan,txtMatKhau;
    Button btnOK,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        AnhXa();
    }

    private void AnhXa()
    {
        txtTaiKhoan=findViewById(R.id.txtTaiKhoan);
        txtMatKhau=findViewById(R.id.txtMatKHau);
        btnHuy=findViewById(R.id.btnHuy);
        btnOK=findViewById(R.id.btnOK);
    }
}