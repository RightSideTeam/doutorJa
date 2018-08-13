package com.rightside.doutorja.modelo;

import java.util.ArrayList;
import java.util.Date;


public class DiasDaSemana {

    private String dataDeHoje;

    private Date time;

    private ArrayList<Hora> horasDoDia;

    public DiasDaSemana(  Date time, String dataDeHoje) {
        this.dataDeHoje = dataDeHoje;
        this.time = time;

    }
    public DiasDaSemana(){}


    public ArrayList<Hora> getHorasDoDia() {
        return horasDoDia;
    }

    public void setHorasDoDia(ArrayList<Hora> horasDoDia) {
        this.horasDoDia = horasDoDia;
    }

    public String getDataDeHoje() {
        return dataDeHoje;
    }

    public void setDataDeHoje(String dataDeHoje) {
        this.dataDeHoje = dataDeHoje;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}



