package com.rightside.doutorja.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.rightside.doutorja.R;
import com.rightside.doutorja.adapter.EspecialidadeAdapter;

import com.rightside.doutorja.modelo.Especialidade;
import com.rightside.doutorja.view.LoginEspecialistaActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EspecialidadeFragment extends Fragment  {


    ArrayList<Especialidade> especialidadeList;



    public EspecialidadeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_especialidade, container, false);




      //  final FirebaseDatabase database = FirebaseDatabase.getInstance();

       // DatabaseReference myRef = database.getReference().child("especialidades");


        especialidadeList = new ArrayList<>();





                    Especialidade clinicoGeral = new Especialidade();

                    clinicoGeral.setNome("CLÍNICO GERAL");
                    clinicoGeral.setIdEspecialidade(0);
                    clinicoGeral.setImagem(R.drawable.novoiconeclinico);
                    especialidadeList.add(clinicoGeral);

                     Especialidade fisioterapeuta = new Especialidade();
                     fisioterapeuta.setNome("FISIOTERAPEUTA");
                     fisioterapeuta.setIdEspecialidade(1);
                     fisioterapeuta.setImagem(R.drawable.novoiconefisio);
                     especialidadeList.add(fisioterapeuta);

                     Especialidade enfermagem = new Especialidade();
                     enfermagem.setNome("ENFERMEIRO");
                     enfermagem.setIdEspecialidade(2);
                     enfermagem.setImagem(R.drawable.novoiconeenfermagem);
                     especialidadeList.add(enfermagem);


                    // myRef.setValue(especialidadeList);


         RecyclerView especialidades = (RecyclerView) view.findViewById(R.id.recyclerview_especialidade_id);

         EspecialidadeAdapter especialidadeAdapter = new EspecialidadeAdapter(getActivity(),especialidadeList);

         especialidades.setLayoutManager(new LinearLayoutManager(getActivity()));

         especialidades.setAdapter(especialidadeAdapter);




         return view;


        }




}


