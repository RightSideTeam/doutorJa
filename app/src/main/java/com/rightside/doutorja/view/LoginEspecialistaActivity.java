package com.rightside.doutorja.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.utils.Singleton;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class LoginEspecialistaActivity extends AppCompatActivity {
    private Button buttonProfissionalEntreNaAgenda;
    DatabaseReference databaseEspecialistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_especialista);
        final ArrayList<Especialista> especialistas = new ArrayList<>();

       // databaseEspecialistas = FirebaseDatabase.getInstance().getReference("especialistas");

        databaseEspecialistas =  FirebaseDatabase.getInstance().getReference("especialistas");

        buttonProfissionalEntreNaAgenda = (Button)findViewById(R.id.buttonEntrarNaAgenda);
        buttonProfissionalEntreNaAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
                EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);

                final String emailEspecialista = editTextEmail.getText().toString().trim();
                final String senhaEspecialista = editTextSenha.getText().toString().trim();

                final ValueEventListener valueEventListener = databaseEspecialistas.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        try {
                            especialistas.clear();
                             final Query query = databaseEspecialistas.orderByChild("email").equalTo(emailEspecialista);
                            query.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                                     Especialista especialista =  dataSnapshot.getValue(Especialista.class);
                                    //Singleton.getInstacia().getEspecialista().setSenha(senhaEspecialista);
                                    Singleton.getInstacia().salva(especialista);
                                    if(especialista.getSenha().equals(senhaEspecialista)){
                                             System.out.println("o dataSnapshot vale"+ especialista.getSenha());
                                            Toast.makeText(LoginEspecialistaActivity.this,"Login efetuado com Sucesso", Toast.LENGTH_LONG).show();
//Intent intent = new Intent(LoginEspecialistaActivity.this,MinicursosActivity.class);
                                            Intent intent = new Intent(LoginEspecialistaActivity.this, AgendaMedicaActivity.class);
                                            startActivity(intent);

                                    }
                                    else {


                                        Toast.makeText(LoginEspecialistaActivity.this,"Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
                                    }



                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });







                        }catch (Exception e){
                            e.printStackTrace();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



                //Intent intencao = new Intent(LoginEspecialistaActivity.this, AgendaMedicaActivity.class);
              //  startActivity(intencao);


            }
        });



    }


}

/*

                            if ((!senhaEspecialista.isEmpty()) && (!emailEspecialista.isEmpty())) {

                                query.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                        especialistas.clear();
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {


                                            Especialista especialista = postSnapshot.getValue(Especialista.class);
                                            especialista.setIdEspecialista(postSnapshot.getKey());
                                            especialistas.add(especialista);


                                            System.out.println("A senha vale " + especialista.getSenha().toString());

                                            if((especialista.getEmail().equals(emailEspecialista))&& (especialista.getSenha().equals(senhaEspecialista))){

                                                    System.out.println("A senha vale " + especialista.getSenha().toString());
                                                    Intent intent = new Intent(LoginEspecialistaActivity.this, AgendaMedicaActivity.class);
                                                    startActivity(intent);
                                            }else{


                                                Toast.makeText(LoginEspecialistaActivity.this, "Senha inválida!", Toast.LENGTH_LONG).show();

                                            }



                                        }


                                    }






                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        Toast.makeText(LoginEspecialistaActivity.this,"Senha inválida!", Toast.LENGTH_LONG).show();


                                    }

                                });

                            }
                            Toast.makeText(LoginEspecialistaActivity.this,"Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();











 */
/*
*
*
*  final ValueEventListener valueEventListener = databaseConsultas.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        try{
                            especialistas.clear();


                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {


                                Especialista  especialista = postSnapshot.getValue(Especialista.class);
                                //especialista.setIdEspecialista(postSnapshot.getKey());

                                //if((((especialista.getEmail().equals(emailEspecialista)))&& (especialista.getSenha().equals(senhaEspecialista)))){
                                    Singleton.getInstacia().getEspecialista().setEmail(emailEspecialista);
                                    Singleton.getInstacia().getEspecialista().setSenha(senhaEspecialista);
                                        Intent intencao = new Intent(LoginEspecialistaActivity.this, AgendaMedicaActivity.class);
                                        startActivity(intencao);
                                //}
                                //else{
                                    Toast.makeText(LoginEspecialistaActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();


                               // }

                            }



                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }


       });


       buttonProfissionalEntreNaAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {


                EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
                EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);

                final String emailEspecialista = editTextEmail.getText().toString();
                final String senhaEspecialista = editTextSenha.getText().toString();



*/