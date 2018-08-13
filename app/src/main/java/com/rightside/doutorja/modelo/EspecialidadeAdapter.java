package com.rightside.doutorja.modelo;

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

import com.rightside.doutorja.view.EspecialistaActivity;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Especialidade;

import java.util.ArrayList;

public class EspecialidadeAdapter extends RecyclerView.Adapter<EspecialidadeAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<Especialidade> listaDeEspecialidade;

    public EspecialidadeAdapter(Context context, ArrayList<Especialidade> listaDeEspecialidade) {
        this.context = context;
        this.listaDeEspecialidade = listaDeEspecialidade;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_especialidade,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
       holder.imagem_especialidade.setImageResource(listaDeEspecialidade.get(position).getImagem());
       holder.nome_especialidade.setText(listaDeEspecialidade.get(position).getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intencao = new Intent(context,EspecialistaActivity.class);

                intencao.putExtra("Especialista",holder.getAdapterPosition());

                context.startActivity(intencao);

            }
        });


    }


    @Override
    public int getItemCount() {
        return listaDeEspecialidade.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome_especialidade;
        ImageView imagem_especialidade;
        CardView  cardView_especialidade;


        public MyViewHolder(View itemView){

            super(itemView);

            nome_especialidade = (TextView ) itemView.findViewById(R.id.especialidade_nome_id);

            imagem_especialidade = (ImageView) itemView.findViewById(R.id.especialidade_imagem_id);

            cardView_especialidade = (CardView) itemView.findViewById(R.id.cardview_especialidade_id);

        }
    }
}
