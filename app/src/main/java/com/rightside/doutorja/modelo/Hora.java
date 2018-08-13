package com.rightside.doutorja.modelo;


import java.io.Serializable;

public class Hora implements Serializable{



    private String id;

    private boolean marcado;

    private String tempo;

    private static Hora uniqueInstance = new Hora();


    public Hora(boolean marcado, String tempo,String id) {
        this.marcado = marcado;
        this.tempo = tempo;
        this.id = id;
    }
    public Hora(){

    }

    public static Hora getInstance() {
        return uniqueInstance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }


}
