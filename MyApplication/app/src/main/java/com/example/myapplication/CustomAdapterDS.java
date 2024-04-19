package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapterDS extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;
    public CustomAdapterDS(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context= context;
        this.resource = resource;
        this.data = data;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTenSP);
        Button btnGioHang = convertView.findViewById(R.id.btnGioHang);

        SanPham sp= data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if (sp.getLoaiSP().equals("Samsung")){
            ivHinh.setImageResource(R.drawable.samsung);
        } else if (sp.getLoaiSP().equals("Iphone")) {
            ivHinh.setImageResource(R.drawable.iphone);
        } else if (sp.getLoaiSP().equals("Nokia")) {
            ivHinh.setImageResource(R.drawable.nokia);
        }

        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Thêm giỏ hàng", Toast.LENGTH_SHORT).show();
                FragmentGioHang.data.add(sp);

            }
        });
        return convertView;
    }
}
