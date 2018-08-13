package com.rightside.doutorja.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.doutorja.R;
import com.rightside.doutorja.adapter.EspecialistaAdapter;
import com.rightside.doutorja.modelo.Especialista;

import java.util.ArrayList;

public class EspecialistaActivity extends AppCompatActivity {


    private Integer especialidadeSelecionada;

    private ArrayList<Especialista> listaDeEspecialista;
    //private ArrayList<String>listaDelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialista);



        especialidadeSelecionada = (Integer) getIntent().getSerializableExtra("Especialista");
        preencheLista();


    }
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();



    private void preencheLista(){
        listaDeEspecialista = new ArrayList<>();


        Especialista clinicoGeral1 ;
        Especialista clinicoGeral2 ;
        Especialista clinicoGeral3 ;
        Especialista clinicoGeral4 ;
        Especialista clinicoGeral5;

        Especialista fisioterapeuta1;
        Especialista fisioterapeuta2;
        Especialista fisioterapeuta3;
        Especialista fisioterapeuta4;
        Especialista fisioterapeuta5;

        Especialista enfermeiro1;
        Especialista enfermeiro2;
        Especialista enfermeiro3;
        Especialista enfermeiro4;
        Especialista enfermeiro5;



      if (especialidadeSelecionada == 0){
           clinicoGeral1 = new Especialista("clinico1@gmail","clinico1","1","ANA DEODORA DA SILVA","Clinico Geral","Rua Itaperuna, 25","Formado em 2010","CRM 0000000000/RJ","(22) 3822-3562",200,R.drawable.medica);
           listaDeEspecialista.add(clinicoGeral1);
           clinicoGeral2 = new Especialista("clinico2@gmail","clinico2","2","CESAR ALBERTO", "Clinico Geral", "Rua Francisco, 255","Formado em 2010","CRM 0000000000/RJ","(22) 3822-3562",15,R.drawable.medico1);
           listaDeEspecialista.add(clinicoGeral2);
           clinicoGeral3 = new Especialista("clinico3@gmail","clinico3","3","GABRIEL BORGES","Clinico Geral","Rua Joseph, 39","Formado em 2010","CRM 0000000000/RJ","(22) 3822-3562",250,R.drawable.medico2);
           listaDeEspecialista.add(clinicoGeral3);
           clinicoGeral4 = new Especialista("clinico4@gmail","clinico4","4","LIDIA FERNANDES","Clinico Geral","Avenida Marechal, 12","Formado em 2010","CRM 0000000000/RJ","(22) 3822-3562",210,R.drawable.medico3);
           listaDeEspecialista.add(clinicoGeral4);
           clinicoGeral5 = new Especialista("clinico5@gmail","clinico5","5","VAGNER NASCIMENTO","Clinico Geral","Rua Linha Amarela","Formado em 2010","CRM 0000000000/RJ","(22) 3822-3562",220,R.drawable.medico4);
           listaDeEspecialista.add(clinicoGeral5);





      }

       else if (especialidadeSelecionada == 1){
           fisioterapeuta1 = new Especialista("fisio1@gmail","fisio1","6","JOÃO MIGUEL TAVARES","Fisioterapeuta","Avenida Silveira Ramos, 147","Formado em 2010","CREFITO 00000-F","(22) 3822-4485",200,R.drawable.fisio1);
           listaDeEspecialista.add(fisioterapeuta1);

           fisioterapeuta2 = new Especialista("fisio2@gmail","fisio2","7","ANDRÉ CARDOSO","Fisioterapeuta", "Rua Coronel Jair, 59","Formado em 2009","CREFITO 00000-F","(22) 3822-4485",200,R.drawable.fisio2);
           listaDeEspecialista.add(fisioterapeuta2);

           fisioterapeuta3 = new Especialista("fisio3@gmail","fisio3","8","VALCIR COSENDEY","Fisioterapeuta","Rua Santo Antônio, 05","Formado em 2012","CREFITO 00000-F","(22) 3822-4485",200,R.drawable.fisio3);
           listaDeEspecialista.add(fisioterapeuta3);

           fisioterapeuta4 = new Especialista("fisio4@gmail","fisio4","9","ADRIAGNES RODRIGUES","Fisioterapeuta","Rua Francisco, 96","Formado em 2016","CREFITO 00000-F","(22) 3822-4485",200,R.drawable.fisio4);
           listaDeEspecialista.add(fisioterapeuta4);

           fisioterapeuta5 = new Especialista("fisio5@gmail","fisio5","10","ANA LÚCIA ALCÂNTARA","Fisioterapeuta","Avenida Liberdade, 27","Formado em 2007","CREFITO 00000-F","(22) 3822-4485",200,R.drawable.fisio5);
           listaDeEspecialista.add(fisioterapeuta5);


      }
      else if(especialidadeSelecionada == 2){
           enfermeiro1 = new Especialista("enfer1@gmail"," enfermeiro1","11","ANA CLARA DA SILVA","Enfermeiro","Avenida Marechal, 39","Formado em 2010","COREN-RJ 000.000","(22) 3822-6985",200,R.drawable.enfermeiro1);
           listaDeEspecialista.add(enfermeiro1);
           enfermeiro2 = new Especialista("enfer2@gmail","enfermeiro2","12","TAIANE ABRANCHES","Enfermeiro", "Rua Piedade Montenegro, 96","Formado em 2010","COREN-RJ 000.000","(22) 3822-6985",200,R.drawable.enfermeiro2);
           listaDeEspecialista.add(enfermeiro2);
           enfermeiro3 = new Especialista("enfer3@gmail","enfermeiro3","13","NÁDIA QUINTA","Enfermeiro","Avenida Germano Estrada, 22","Formado em 2010","COREN-RJ 000.000","(22) 3822-6985",200,R.drawable.enfermeiro3);
           listaDeEspecialista.add(enfermeiro3);
           enfermeiro4 = new Especialista("enfer4@gmail","enfermeiro4","14","MARLI BORGES","Enfermeiro","Rua Dionísio Mourão, 125","Formado em 2010","COREN-RJ 000.000","(22) 3822-6985",200,R.drawable.enfermeiro4);
           listaDeEspecialista.add(enfermeiro4);
           enfermeiro5 = new Especialista("enfer5@gmail"," enfermeiro5","15","ISMAEL LOPES","Enfermeiro","Avenida Olívio Andrade, 55","Formado em 2010","COREN-RJ 000.000","(22) 3822-6985",200,R.drawable.enfermeiro5);
           listaDeEspecialista.add(enfermeiro5);

       }

     // myRef.child("especialistas").setValue(listaDeEspecialista);

       RecyclerView medicos = (RecyclerView)findViewById(R.id.recyclerview_especialista_id);


       EspecialistaAdapter especialistaAdapter = new EspecialistaAdapter(this, listaDeEspecialista);

       medicos.setLayoutManager(new LinearLayoutManager(this));

       medicos.setAdapter(especialistaAdapter);


   }



}
