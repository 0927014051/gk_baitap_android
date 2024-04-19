package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapterSP extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;
    public CustomAdapterSP(@NonNull Context context, int resource, List<SanPham> data) {
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
        SanPham sp= data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if (sp.getLoaiSP().equals("Samsung")){
            ivHinh.setImageResource(R.drawable.samsung);
        } else if (sp.getLoaiSP().equals("Iphone")) {
            ivHinh.setImageResource(R.drawable.iphone);
        } else if (sp.getLoaiSP().equals("Nokia")) {
            ivHinh.setImageResource(R.drawable.nokia);
        }
        return convertView;
    }
}
