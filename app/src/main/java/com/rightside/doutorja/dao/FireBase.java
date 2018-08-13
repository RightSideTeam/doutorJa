package com.rightside.doutorja.dao;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rightside.doutorja.modelo.Usuario;

import static android.content.ContentValues.TAG;

public class FireBase {


     private DatabaseReference myRef;
     private Usuario usuario;

     public FireBase(){
          myRef = FirebaseDatabase.getInstance().getReference();

     }

     public Usuario recuperarUsuarioDoBanco(String UsuarioId){

          myRef.child("usuarios").child(UsuarioId);


          ValueEventListener listener = new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                    usuario = dataSnapshot.getValue(Usuario.class); //não funciona

               }

               @Override
               public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "Ação Cancelada", databaseError.toException());

               }
          };
          myRef.addValueEventListener(listener);

          return usuario;
     }






}
