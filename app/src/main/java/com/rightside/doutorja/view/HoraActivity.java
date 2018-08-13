package com.rightside.doutorja.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.doutorja.R;
import com.rightside.doutorja.adapter.HoraAdapter;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.modelo.Hora;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HoraActivity extends AppCompatActivity {

    private ArrayList<Hora> listaDeHora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora);


        //DatabaseReference myRef = database.getReference();

        listaDeHora = new ArrayList<>();

        listaDeHora.add(new Hora(false,"8:00hs","1"));
        listaDeHora.add(new Hora(false,"9:00hs","1"));
        listaDeHora.add(new Hora(false,"10:00hs","1"));
        listaDeHora.add(new Hora(false,"11:00hs","1"));
        listaDeHora.add(new Hora(false,"13:00hs","1"));
        listaDeHora.add(new Hora(false,"14:00hs","1"));
        listaDeHora.add(new Hora(false,"15:00hs","1"));
        listaDeHora.add(new Hora(false,"16:00hs","1"));
        listaDeHora.add(new Hora(false,"17:00hs","1"));
        listaDeHora.add(new Hora(false,"18:00hs","1"));

      //  myRef.child("horarios").setValue(listaDeHora);

        RecyclerView horas = (RecyclerView) findViewById(R.id.recyclerview_hora_id);

        HoraAdapter horaAdapter = new HoraAdapter(this,listaDeHora);

        horas.setLayoutManager(new LinearLayoutManager(this));

        horas.setAdapter(horaAdapter);




    }

}
