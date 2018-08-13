package com.rightside.doutorja.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rightside.doutorja.view.HoraActivity;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.DiasDaSemana;
import com.rightside.doutorja.utils.Singleton;

import java.util.ArrayList;

public class DiasDaSemanaAdapter extends RecyclerView.Adapter<DiasDaSemanaAdapter.MyViewHolder> {

    private Context context;
    
    private ArrayList<DiasDaSemana> listaDeDiasDaSemana;


    public DiasDaSemanaAdapter(Context context, ArrayList<DiasDaSemana> listaDeDiasDaSemana) {

        this.context = context;
        this.listaDeDiasDaSemana = listaDeDiasDaSemana;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_dias,parent,false);
        return new MyViewHolder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //final DiasDaSemana diasDaSemana = listaDeDiasDaSemana.get(position);
        holder.diaDoMes.setText(listaDeDiasDaSemana.get(position).getDataDeHoje());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstacia().salvaDiaDaSemana(listaDeDiasDaSemana.get(position));


                Intent intencao = new Intent(context, HoraActivity.class);
                intencao.putExtra("Dia",holder.getAdapterPosition());
                context.startActivity(intencao);

            }

        });


    }

    @Override
    public int getItemCount() {
        return listaDeDiasDaSemana.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardViewDiaEscolhido;
        TextView diaDoMes;

        public MyViewHolder(View itemView) {

            super(itemView);

            cardViewDiaEscolhido = itemView.findViewById(R.id.cardview_dia_escolhido_id);
            diaDoMes = itemView.findViewById(R.id.dia_atual_id);

        }



    }







}