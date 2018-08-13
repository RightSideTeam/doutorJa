package com.rightside.doutorja.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Usuario;
import com.rightside.doutorja.view.LoginEspecialistaActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private Button buttonProfissionalEntre;

    private TextView textViewNome;
    private TextView textViewEmail;
    private TextView textViewDataDeNascimento;
    private Usuario usuario;


    public PerfilFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_perfil, container, false);


        entrarProfi(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
        String nome = sharedPreferences.getString("nome", "");
        String email = sharedPreferences.getString("email", "");


        textViewNome = getView().findViewById(R.id.nome_perfil_usuario);
        textViewEmail = getView().findViewById(R.id.emailperfiltext2);




        textViewNome.setText(nome);

        textViewEmail.setText(email);



    }
    private void entrarProfi(View view) {
        buttonProfissionalEntre = (Button) view.findViewById(R.id.button_profissional_entrarNoLogin);
        buttonProfissionalEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intencao = new Intent(getActivity(), LoginEspecialista.class);
                Intent intencao = new Intent(getActivity(),LoginEspecialistaActivity.class);

                startActivity(intencao);

            }
        });
    }


}