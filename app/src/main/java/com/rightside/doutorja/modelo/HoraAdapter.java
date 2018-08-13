package com.rightside.doutorja.modelo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.utils.ConsultaList;
import com.rightside.doutorja.utils.Singleton;
import com.rightside.doutorja.view.DiaDaSemanaActivity;
import com.rightside.doutorja.view.MainActivity;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Hora;
import com.rightside.doutorja.utils.ConsultaUtils;

import java.util.ArrayList;
import java.util.List;

public class HoraAdapter extends RecyclerView.Adapter<HoraAdapter.MyViewHolder>{

    private Context context;

    private ArrayList<Hora> listaDeHora;

    List<Consulta> consultas;
    DatabaseReference myRef;
    boolean infla = true;





    public HoraAdapter(Context context, ArrayList<Hora> listaDeHora) {
        this.context = context;
        this.listaDeHora = listaDeHora;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_hora,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        myRef =  FirebaseDatabase.getInstance().getReference("consultas");

        final Hora hora = listaDeHora.get(position);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Consulta consulta = postSnapshot.getValue(Consulta.class);
                    consulta.setIdConsulta(postSnapshot.getKey());

                    if(Singleton.getInstacia().getEspecialista().getIdEspecialista().equals(consulta.getIdEspecialista())){
                        if(Singleton.getInstacia().getDiasDaSemana().getDataDeHoje().equals(consulta.getDataConsulta())){
                            if(consulta.getHoraConsulta().equals(hora.getTempo())){
                                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.Vermelho));
                                holder.itemView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                          notificaHorarioMarcado();
                                           return;
                                     }
                                });

                            }

                            else{
                                holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());

                            }

                        }else{
                            holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());

                        }

                    }else{
                        holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
                alertDialog.setTitle("Deseja confirmar?");
                alertDialog.setMessage("Você deseja marcar seu atendimento para às "+hora.getTempo()+"?");
                alertDialog.setIcon(R.drawable.ic_notifications_black_24dp);
                alertDialog.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                marcaConsulta(holder,hora);

                            }


                        });
                alertDialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, "Sua tentativa foi Cancelada "+listaDeHora.get(position).getId(), Toast.LENGTH_SHORT).show();

                            }
                        });
                alertDialog.show();

            }




        });

/*
                  }else{
                 AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                  alertDialog.setTitle("Atenção");
                  alertDialog.setMessage("Infelizmente esse horário está maracado");
                  alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                  new DialogInterface.OnClickListener() {

                  public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                     }
                   });
                  alertDialog.show();

             }
*/

    }


    public void marcaConsulta(@NonNull MyViewHolder holder, Hora hora) {
        ConsultaUtils consulta = new ConsultaUtils();
        hora.setMarcado(true);
        Toast.makeText(context, " Marcado  para às "+hora.getTempo()+" com sucesso", Toast.LENGTH_SHORT).show();

        myRef.push().setValue(consulta.salvaConsultaNa(hora));

        Intent intent = new Intent(context,DiaDaSemanaActivity.class);
        context.startActivity(intent);



    }

    @Override
    public int getItemCount() {
        return listaDeHora.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView horaEscolhida;
        CardView cardViewHoraEscolhida;

        public MyViewHolder(View itemView){
            super(itemView);

            horaEscolhida = itemView.findViewById(R.id.hora_id);
            cardViewHoraEscolhida = itemView.findViewById(R.id.cardview_hora_id);


        }

    }
    private void notificaHorarioMarcado() {
        infla = true;
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Atenção");
        alertDialog.setMessage("Infelizmente esse horário está marcado");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}

/*
* if(Singleton.getInstacia().getEspecialista().getIdEspecialista().equals(consulta.getIdEspecialista())){
                 if(Singleton.getInstacia().getDiasDaSemana().getDataDeHoje().equals(consulta.getDataConsulta())){



                            if(listaDeHora.get(position).getTempo().equals(listaDeConsulta.get(position).getTempo())) {
                                //não infla

                            }
                            else {
                                  holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());

                            }
                   }
                  else{
                       holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());

                  }

         }
        else{
            holder.horaEscolhida.setText(listaDeHora.get(position).getTempo());


         }

}



*
*
*
* */