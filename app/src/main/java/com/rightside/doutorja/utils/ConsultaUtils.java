package com.rightside.doutorja.utils;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.modelo.DiasDaSemana;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.modelo.Hora;
import com.rightside.doutorja.modelo.Usuario;

import java.util.List;

public class ConsultaUtils {


    List<Consulta> consultasMarcadas;


    DatabaseReference databaseConsultas;

    Especialista especialista = Singleton.getInstacia().getEspecialista();

    DiasDaSemana diasDaSemana = Singleton.getInstacia().getDiasDaSemana();

    Usuario usuario = Singleton.getInstacia().getUsuario();



    // Firebase firebase;
    public Consulta salvaConsultaNa(Hora hora){
        databaseConsultas = FirebaseDatabase.getInstance().getReference("consultas");
        Context context;

        final Consulta consulta = new Consulta();

        if (usuario != null){
            consulta.setEmailUsuario(usuario.getEmail());
            consulta.setNomeUsuario(usuario.getNome());
        }

        else {
            consulta.setNomeUsuario("Horário bloqueado");
            consulta.setEmailUsuario(especialista.getEmail());
        }






        consulta.setNomeEspecialista(especialista.getNome());
        consulta.setDataConsulta(diasDaSemana.getDataDeHoje());
        consulta.setHoraConsulta(hora.getTempo());
        consulta.setIdEspecialista(especialista.getIdEspecialista());
        consulta.setIdHoraConsulta(hora.getId());
        consulta.setConsultaMarcada(hora.isMarcado());
        consulta.setSenhaEspecialista(especialista.getSenha());
        consulta.setEmailEspecialista(especialista.getEmail());








        /*consulta.setEspecialista(Singleton.getInstacia().getEspecialista());
        consulta.setHoraDaConsulta(hora);
        consulta.setUsuario(usuario);
        consulta.setDiaDaSemana(Singleton.getInstacia().getDiasDaSemana());

        */



        final ValueEventListener valueEventListener = databaseConsultas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try{
                    consultasMarcadas.clear();


                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        Consulta consultaBanco = postSnapshot.getValue(Consulta.class);
                        //consultaBanco.setIdConsulta(postSnapshot.getKey());







                    }



                    //ConsultaList consultaAdapter = new ConsultaList(getActivity(), consultas);


                   // listViewConsultas.setAdapter(consultaAdapter);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return consulta;
    }



}

