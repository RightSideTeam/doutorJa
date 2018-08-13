package com.rightside.doutorja.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.doutorja.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DomicilioFragment extends Fragment {


    public DomicilioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_domicilio, container, false);
    }

}
