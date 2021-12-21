package com.imanancin.utangapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imanancin.utangapp.R;
import com.imanancin.utangapp.adapter.DipinjamRecyclerViewAdapter;
import com.imanancin.utangapp.model.DataModel;

import java.util.ArrayList;

public class DipinjamFragment extends Fragment {

    private RecyclerView recyclerView;
    private DipinjamRecyclerViewAdapter adapter;

    // untuk menampung data listnya dengan arrayList
    ArrayList<DataModel> dm = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(R.string.dipinjam);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dipinjam, container, false);
        recyclerView = view.findViewById(R.id.recyc_dipinjam);
        recyclerView.setHasFixedSize(true);

        // TODO: set adapter
        // masukkan datanya lalu set adapter
        dm.add(new DataModel("Iman Nurzaman","12 Desember 2021", 50000));
        dm.add(new DataModel("Azi Samsul","17 Desember 2021", 30000));
        dm.add(new DataModel("Azi Samsul","17 Desember 2021", 30000));
        dm.add(new DataModel("Azi Samsul","17 Desember 2021", 30000));
        adapter = new DipinjamRecyclerViewAdapter(dm);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}