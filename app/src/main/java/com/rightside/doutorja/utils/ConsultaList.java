package com.rightside.doutorja.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.rightside.doutorja.R;

import com.rightside.doutorja.modelo.Consulta;

import java.util.List;

public class ConsultaList extends ArrayAdapter<Consulta> {
    private Activity context;
    List<Consulta> consultas;

    public ConsultaList(Activity context, List<Consulta> consultas) {
        super(context, R.layout.consulta_lista, consultas);
        this.context = context;
        this.consultas = consultas;
    }





    @Override
        public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.consulta_lista, null, false);

            TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewNameProfissional);
            TextView textViewDia = (TextView) listViewItem.findViewById(R.id.textViewDiaDaConsulta);
            TextView textViewHora = (TextView) listViewItem.findViewById(R.id.textViewHoraDaConsulta);
            TextView textViewUsuario = (TextView) listViewItem.findViewById(R.id.textViewUsuarioDaConsulta);

            Consulta consulta = consultas.get(position);

            textViewName.setText(consulta.getNomeEspecialista());
            textViewDia.setText(consulta.getDataConsulta());
            textViewHora.setText(consulta.getHoraConsulta());
            textViewUsuario.setText(consulta.getNomeUsuario());



            return listViewItem;
        }


}
/*

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Artist artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        textViewGenre.setText(artist.getArtistGenre());

 */