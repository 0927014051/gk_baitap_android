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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSP;
    Spinner spLoaiSP;
    List<String> data_lsp = new ArrayList<>();
    ArrayAdapter adapter_lsp;
    Button btnThem, btnXoa, btnSua, btnThoat, btnChiTiet;
    ImageView ivHinh;
    ListView lvSP;
    List<SanPham> data_sp = new ArrayList<>();
    CustomAdapterSP adapter_sp;
    int index = -1;
    DatabaseSP databaseSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();


    }

    private void setEvent() {
        KhoiTao();
        databaseSP = new DatabaseSP(this);
        adapter_lsp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiSP.setAdapter((adapter_lsp));
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiSP.getSelectedItem().toString().equals("Samsung")){
                    ivHinh.setImageResource(R.drawable.samsung);
                }else if(spLoaiSP.getSelectedItem().toString().equals(("Iphone"))){
                    ivHinh.setImageResource(R.drawable.iphone);
                } else if (spLoaiSP.getSelectedItem().toString().equals("Nokia")) {
                    ivHinh.setImageResource(R.drawable.nokia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter_sp = new CustomAdapterSP(this, R.layout.layout_listview, data_sp);
        lvSP.setAdapter(adapter_sp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemSP();
                DocDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sp = new SanPham();
                sp.setMaSP(edtMaSP.getText().toString());
                databaseSP.XoaDL(sp);
                DocDL();
            }
        });
        lvSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = data_sp.get(position);
                edtMaSP.setText(sp.getMaSP());
                edtTenSP.setText(sp.getTenSP());
                edtGiaSP.setText(sp.getGiaSP());
                if(sp.getLoaiSP().equals("Samsung")){
                    spLoaiSP.setSelection(0);
                } else if (sp.getLoaiSP().equals("Iphone")) {
                    spLoaiSP.setSelection(1);
                } else if (sp.getLoaiSP().equals("Nokia")) {
                    spLoaiSP.setSelection(2);
                }
                index = position;

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sp= data_sp.get(index);
                sp.setMaSP(edtMaSP.getText().toString());
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                databaseSP.SuaDL(sp);
                DocDL();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void ThemSP() {
        SanPham sp = new SanPham();
        sp.setMaSP(edtMaSP.getText().toString());
        sp.setTenSP(edtTenSP.getText().toString());
        sp.setGiaSP(edtGiaSP.getText().toString());
        sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
        databaseSP.ThemDL(sp);
    }
    @Override
    protected void onResume(){
        super.onResume();
        DocDL();
    }
    private void DocDL(){
        data_sp.clear();
        data_sp.addAll(databaseSP.DocDL());
        adapter_sp.notifyDataSetChanged();
    }
    private void KhoiTao(){
        data_lsp.add("Samsung");
        data_lsp.add("Iphone");
        data_lsp.add("Nokia");
    }

    private void setControl() {
        edtMaSP= findViewById(R.id.edtMaSP);
        edtTenSP= findViewById(R.id.edtTenSP);
        edtGiaSP= findViewById(R.id.edtGiaSP);
        spLoaiSP= findViewById(R.id.spLoaiSP);
        ivHinh= findViewById(R.id.ivHinh);
        btnThem= findViewById(R.id.btnThem);
        btnXoa= findViewById(R.id.btnXoa);
        btnSua= findViewById(R.id.btnSua);
        btnThoat= findViewById(R.id.btnThoat);
        btnChiTiet= findViewById(R.id.btnChiTiet);
        lvSP= findViewById(R.id.lvSP);

    }

}