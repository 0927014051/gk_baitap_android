package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class FragmentDanhSach extends Fragment {
    GridView gvDanhSach;
    CustomAdapterDS adapterdS;
    List<SanPham> data= new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        DatabaseSP databaseSP = new DatabaseSP(getActivity());
        data.addAll(databaseSP.DocDL());
        adapterdS = new CustomAdapterDS(getContext(), R.layout.layout_listview_ds, data);
        gvDanhSach.setAdapter(adapterdS);
    }

    private void setControl(View view) {
        gvDanhSach = view.findViewById(R.id.gvDanhSach);
    }
}