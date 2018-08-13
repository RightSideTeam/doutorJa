package com.rightside.doutorja.utils;

import com.rightside.doutorja.modelo.DiasDaSemana;
import com.rightside.doutorja.modelo.Especialista;
import com.rightside.doutorja.modelo.Usuario;

public class Singleton {

    private static Singleton instancia;
    private Especialista especialista;
    private DiasDaSemana diasDaSemana;
    private Usuario usuario;

    public Singleton(){}

    public static Singleton getInstacia(){

        if(instancia == null){
            instancia = new Singleton();
        }

        return instancia;
    }

    public void salva(Especialista especialista) {
        this.especialista = especialista;
    }

    public void salvaUsuario(Usuario usuario){this.usuario = usuario;}

    public Usuario getUsuario() {
        return usuario;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void salvaDiaDaSemana(DiasDaSemana diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public DiasDaSemana getDiasDaSemana(){
        return diasDaSemana;
    }
}
