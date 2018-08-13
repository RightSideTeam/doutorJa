package com.rightside.doutorja.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.doutorja.R;
import com.rightside.doutorja.adapter.EspecialidadeAdapter;
import com.rightside.doutorja.modelo.Especialidade;

import java.util.ArrayList;


public class EspecialidadeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_especialidade);




    }



}
