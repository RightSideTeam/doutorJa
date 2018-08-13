package com.rightside.doutorja.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.DiasDaSemana;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.utils.Singleton;


public class EspecialistaEscolhidoActivity extends AppCompatActivity {

    private TextView nomeEspecialistaEscolhido;

    private TextView especialidadeEspecialista;

    private TextView regitroEspecialistaEscolhido;

    private TextView enderecoEspecialistaEscolhido;

    private TextView anoFormacaoEspecialistaEscolhido;

    private TextView telefoneEspecialistaEscolhido;

    private ImageView imagemEspecialistaEscolhido;

    private TextView valorAtendimento;

    private Button buttonMarqueAqui;

    public Especialista especialista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialista_escolhido);

        nomeEspecialistaEscolhido = findViewById(R.id.especialista_nome_id);
        especialidadeEspecialista = findViewById(R.id.especialista_especialidade_id);
        regitroEspecialistaEscolhido = findViewById(R.id.especialista_registro_profissional_id);
        enderecoEspecialistaEscolhido = findViewById(R.id.especialista_endereco_id);
        anoFormacaoEspecialistaEscolhido = findViewById(R.id.especialista_ano_formacao_id);
        telefoneEspecialistaEscolhido = findViewById(R.id.especialista_telefone_id);
        imagemEspecialistaEscolhido = findViewById(R.id.especialista_imagem_id);
        valorAtendimento = findViewById(R.id.especialista_valor_atendimento_id);
        buttonMarqueAqui = findViewById(R.id.buton_marcar_atendimento_id);

        buttonMarqueAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Intent intencao = new Intent(EspecialistaEscolhidoActivity.this,DiaDaSemanaActivity.class);

              Intent intencao = new Intent(EspecialistaEscolhidoActivity.this,LoginActivity.class);
                intencao.putExtra("Especialista",especialista);
                startActivity(intencao);

            }
        });


        especialista = Singleton.getInstacia().getEspecialista();

        //  int imagem = intencao.getExtras().getInt("Imagem");

        //  double valor = intencao.getExtras().getDouble("Valor");


        //  String valorConvertido = String.valueOf(valor);


          nomeEspecialistaEscolhido.setText(especialista.getNome());
          especialidadeEspecialista.setText((especialista.getEspecialidadeEspecialista()));
          enderecoEspecialistaEscolhido.setText(especialista.getEnderecoEspecialista());
          anoFormacaoEspecialistaEscolhido.setText(especialista.getAnoDeFormacao());
          regitroEspecialistaEscolhido.setText(especialista.getRegistroProfissional());
          telefoneEspecialistaEscolhido.setText(especialista.getTelefone());
          imagemEspecialistaEscolhido.setImageResource(especialista.getImagemPerfil());
        // valorAtendimento.setText("Valor do Atendimento "+valorConvertido);






    }
}
