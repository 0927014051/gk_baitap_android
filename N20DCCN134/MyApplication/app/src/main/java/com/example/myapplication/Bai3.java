package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai3 extends AppCompatActivity {

    EditText edtTaikhoan, edtMatkhau, edtNgaysinh, edtEmail;
    TextView tvMessage;
    Button btnDangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        setControl();
        setEvent();
    }

    private void setEvent() {
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtTaikhoan.getText().toString().equals("")){
                    edtTaikhoan.setError("Yêu cầu nhập tài khoản");
                    edtTaikhoan.requestFocus();
                } else if (edtMatkhau.getText().toString().equals("")) {
                    edtMatkhau.setError("Yêu cầu nhập mật khẩu");
                    edtMatkhau.requestFocus();
                } else if (edtNgaysinh.getText().toString().equals("")) {
                    edtNgaysinh.setError("Yêu cầu nhập ngày sinh");
                    edtNgaysinh.requestFocus();
                } else if (edtEmail.getText().toString().equals("")) {
                    edtEmail.setError("Yêu cầu nhập Email");
                    edtEmail.requestFocus();
                }else {
                    Dangky();
                }
            }
        });
    }
    private void Dangky() {
        String msg ="Thông tin";
        msg += "\nTài khoản: " + edtTaikhoan.getText().toString();
        msg += "\nMật khẩu: " + edtMatkhau.getText().toString();
        msg += "\nNgày sinh: " + edtNgaysinh.getText().toString();
        msg += "\nEmail: " + edtEmail.getText().toString();
        tvMessage.setText(msg);
        tvMessage.setBackgroundColor(Color.GREEN);
    }
    private void setControl() {
        edtTaikhoan = (EditText) findViewById(R.id.edtTaikhoan);
        edtMatkhau = (EditText)  findViewById(R.id.edtMatkhau);
        edtNgaysinh= (EditText) findViewById(R.id.edtNgaysinh);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btnDangky = (Button) findViewById(R.id.btnDangky);
    }
}