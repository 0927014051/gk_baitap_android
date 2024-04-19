package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPham extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSP;
    Button  btnXoa, btnSua, btnBack;
    DatabaseSP databaseSP;
    SanPham sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        databaseSP = new DatabaseSP(this);
        setControl();
        setEvent();
    }
    private void setEvent() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sp = new SanPham();
                sp.setMaSP(edtMaSP.getText().toString());
                databaseSP.XoaDL(sp);
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();
                finish();

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setMaSP(edtMaSP.getText().toString());
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                databaseSP.SuaDL(sp);
                Toast.makeText(getApplicationContext(), "Sửa thành công!", Toast.LENGTH_LONG).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void setControl() {
        edtMaSP= findViewById(R.id.edtMaSP);
        edtTenSP= findViewById(R.id.edtTenSP);
        edtGiaSP= findViewById(R.id.edtGiaSP);
        btnXoa= findViewById(R.id.btnXoa);
        btnSua= findViewById(R.id.btnSua);
        btnBack= findViewById(R.id.btnBack);

        sp = (SanPham)getIntent().getSerializableExtra("item");

        edtMaSP.setText(sp.getMaSP());
        edtTenSP.setText(sp.getTenSP());
        edtGiaSP.setText(sp.getGiaSP());
    }

}