package com.rightside.doutorja.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.modelo.Usuario;
import com.rightside.doutorja.utils.ConsultaList;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.utils.Singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class MinhasConsultasFragment extends Fragment {
    ListView listViewConsultas;
    Context context;

    List<Consulta> consultas;


    DatabaseReference databaseConsultas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_minhas_consultas, container, false);



       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseConsultas = FirebaseDatabase.getInstance().getReference("consultas");


        listViewConsultas = (ListView) view.findViewById(R.id.listViewConsultas_id);


        consultas = new ArrayList<>();

        listViewConsultas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Consulta consulta = consultas.get(i);

                showUpdateDeleteDialog(consulta.getIdConsulta(), consulta.getNomeEspecialista());
                return true;
            }
        });

       return view;
    }

    public void buscaConsultas(){
        final ValueEventListener valueEventListener = databaseConsultas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try{
                    consultas.clear();


                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Usuario usuario = Singleton.getInstacia().getUsuario();


                        Consulta consulta = postSnapshot.getValue(Consulta.class);
                        consulta.setIdConsulta(postSnapshot.getKey());

                        if(consulta.getEmailUsuario().equals(usuario.getEmail())){
                            consultas.add(consulta);
                        }

                    }
                    Collections.reverse(consultas);



                    //Collections.reverse(consultas);
                    ConsultaList consultaAdapter = new ConsultaList(getActivity(), consultas);


                    listViewConsultas.setAdapter(consultaAdapter);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void onStart() {
        super.onStart();

        buscaConsultas();
    }
    private void showUpdateDeleteDialog(final String consultaId, String consultaNomeProfissional) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_diolog, null);
        dialogBuilder.setView(dialogView);


        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteConsulta);

        dialogBuilder.setTitle(" Desmarcar com "+consultaNomeProfissional);
        final AlertDialog b = dialogBuilder.create();
        b.show();



        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteConsulta(consultaId);
                b.dismiss();
            }
        });
    }
    //public void ordenaLista(List<Consulta>consultas){
    //    Collections.reverse(consultas);
    //    this.consultas = consultas;

    //}

    private boolean deleteConsulta(String id) {

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("consultas");

        dR.child(id).removeValue();
        buscaConsultas();
        Toast.makeText(getActivity(), "Consulta desmarcada com sucesso", Toast.LENGTH_LONG).show();

        return true;
    }


}