package com.rightside.doutorja.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Consulta;

import com.rightside.doutorja.modelo.Usuario;

import java.util.ArrayList;

public class FirebaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        // Write a message to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
        String id = sharedPreferences.getString(getString(R.string.id), "");


        DatabaseReference myRef = database.getReference("usuarios");

        Usuario user = new Usuario();
        user.setNome("Valcir");
        user.setEmail("valcirjr98@gmail.com");
        user.setDataDeNascimento("31/05/1998");
        user.setSenha("123");
        user.setConfirmaSenha("123");
        Consulta consulta = new Consulta();

        user.setListaDeConsultas(new Consulta());




        database.getReference().child(id).child("usuários").push().setValue(user);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<Usuario> usuarios = new ArrayList<>();
                for(DataSnapshot dado : dataSnapshot.getChildren()){
                    Usuario usuario = dado.getValue(Usuario.class);
                    usuarios.add(usuario);
                    Log.v("doutorja", "\n\n\n\nUsuario " +  usuario.getNome());


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("usuario", "Deu merda!");

            }
        });




    }
}