package com.rightside.doutorja.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rightside.doutorja.R;
import com.rightside.doutorja.adapter.DiasDaSemanaAdapter;
import com.rightside.doutorja.modelo.DiasDaSemana;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Locale;


import static com.rightside.doutorja.R.layout.activity_dia_semana;


public class DiaDaSemanaActivity extends AppCompatActivity {


    private ArrayList<DiasDaSemana> listaDeDiasDaSemana;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_dia_semana);

        listaDeDiasDaSemana = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        calendar.set(Calendar.WEEK_OF_MONTH, weekOfMonth);

       //Locale pt = new Locale("pt","BR");
        DateFormat dateFormatf = new SimpleDateFormat("  dd/MM/yyyy");


        calendar.add(Calendar.DATE, 1);
        for (int i = 0; i < 10; i++) {
            listaDeDiasDaSemana.add(new DiasDaSemana(calendar.getTime(), dateFormatf.format(calendar.getTime())));

            if (calendar.get(Calendar.DAY_OF_WEEK) == 6){ //Se for Sexta aumenta 2 dias.
                   calendar.add(Calendar.DATE,2);
            }

            calendar.add(Calendar.DATE, 1);
        }


        RecyclerView dias = (RecyclerView) findViewById(R.id.recyclerview_dia_id);

        DiasDaSemanaAdapter diasDaSemanaAdapter = new DiasDaSemanaAdapter(this,listaDeDiasDaSemana);

        dias.setLayoutManager(new LinearLayoutManager(this));

        dias.setAdapter(diasDaSemanaAdapter);


        }


}
