package com.rightside.doutorja.view;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.utils.ConsultaList;
import com.rightside.doutorja.utils.Singleton;

import java.util.ArrayList;
import java.util.List;

public class AgendaMedicaActivity extends AppCompatActivity {

    ListView listViewConsultas;

    List<Consulta> consultas;

    private Button buttonMinicurso;
    private Button buttonMontarAgenda;
    Especialista especialista;



    DatabaseReference databaseConsultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_medica);

        buttonMontarAgenda = findViewById(R.id.buttonParaMontarAgenda);
        buttonMinicurso = findViewById(R.id.buttonParaOMinicurso);

        buttonMontarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(AgendaMedicaActivity.this,DiaDaSemanaActivity.class);

                // Intent intencao = new Intent(EspecialistaEscolhidoActivity.this,LoginActivity.class);
                intencao.putExtra("Especialista",especialista);
                startActivity(intencao);

            }
        });

        buttonMinicurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intencao = new Intent(AgendaMedicaActivity.this, MinicursosActivity.class);

                startActivity(intencao);

            }

        });





        databaseConsultas = FirebaseDatabase.getInstance().getReference("consultas");



        listViewConsultas = (ListView) findViewById(R.id.listViewAgenda_id);


        //list to store artists
        consultas = new ArrayList<>();



        listViewConsultas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Consulta consulta = consultas.get(i);

                showUpdateDeleteDialog(consulta.getIdConsulta(), consulta.getNomeEspecialista());
                return true;
            }
        });


    }


    public void buscaConsultas(){
        final ValueEventListener valueEventListener = databaseConsultas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try{
                    consultas.clear();


                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Especialista especialista = Singleton.getInstacia().getEspecialista();


                        Consulta consulta = postSnapshot.getValue(Consulta.class);
                        consulta.setIdConsulta(postSnapshot.getKey());
                        if(consulta.getEmailEspecialista().equals(especialista.getEmail())){

                            consultas.add(consulta);
                        }

                    }


                    ConsultaList consultaAdapter = new ConsultaList(AgendaMedicaActivity.this, consultas);

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

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_diolog_agenda, null);
        dialogBuilder.setView(dialogView);

        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteConsultaAgenda);

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

    private boolean deleteConsulta(String id) {

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("consultas");

        Toast.makeText(getApplicationContext(), "Teste " + id, Toast.LENGTH_LONG).show();
        dR.child(id).removeValue();
        buscaConsultas();
        Toast.makeText(getApplicationContext(), "Consulta desmarcada com sucesso", Toast.LENGTH_LONG).show();

        return true;
    }
}
