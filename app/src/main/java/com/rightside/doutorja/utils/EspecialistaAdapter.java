package com.rightside.doutorja.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.rightside.doutorja.view.EspecialistaEscolhidoActivity;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.utils.Singleton;

import java.util.ArrayList;


public class EspecialistaAdapter extends RecyclerView.Adapter<EspecialistaAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<Especialista> listaDeEspecialista;

    public EspecialistaAdapter(Context context, ArrayList<Especialista> listaDeEspecialista) {

        this.context = context;
        this.listaDeEspecialista = listaDeEspecialista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_especialista,parent,false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.imagem_especialista.setImageResource(listaDeEspecialista.get(position).getImagemPerfil());

        holder.especialidade_especialista.setText(listaDeEspecialista.get(position).getEspecialidadeEspecialista());

        holder.endereco_especialista.setText(listaDeEspecialista.get(position).getEnderecoEspecialista());

        holder.nome_especialista.setText(listaDeEspecialista.get(position).getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intencao = new Intent(context, EspecialistaEscolhidoActivity.class);
                Singleton.getInstacia().salva(listaDeEspecialista.get(position));
                context.startActivity(intencao);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listaDeEspecialista.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView nome_especialista;
        TextView especialidade_especialista;
        TextView endereco_especialista;
        ImageView imagem_especialista;
        CardView cardView_especialista;





        public MyViewHolder(View itemView){

            super(itemView);

            nome_especialista = (TextView) itemView.findViewById(R.id.medico_nome_id);
            especialidade_especialista = (TextView) itemView.findViewById(R.id.especialista_especialidade_id);
            endereco_especialista = (TextView) itemView.findViewById(R.id.medico_endereco_id);
            imagem_especialista = (ImageView) itemView.findViewById(R.id.medico_imagem_id);
            cardView_especialista = (CardView) itemView.findViewById(R.id.cardview_especialista_id);

        }


    }
}