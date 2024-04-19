package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentGioHang extends Fragment {
    ListView lvGioHang;
    ArrayAdapter arrayAdapter;
    public static List<SanPham> data = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data);
        lvGioHang.setAdapter(arrayAdapter);
    }

    private void setControl(View view) {
        lvGioHang = view.findViewById(R.id.lvGioHang);
    }
}