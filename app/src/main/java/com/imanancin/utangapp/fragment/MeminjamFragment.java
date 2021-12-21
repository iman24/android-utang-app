package com.imanancin.utangapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imanancin.utangapp.R;

public class MeminjamFragment extends Fragment {

    public MeminjamFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.meminjam);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meminjam, container, false);
    }
}