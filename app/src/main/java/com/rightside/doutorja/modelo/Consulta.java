package com.rightside.doutorja.modelo;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Consulta implements Serializable{

     String idConsulta;
    // Especialista especialista;
    // DiasDaSemana diaDaSemana;
    // Hora horaDaConsulta;
    // Usuario usuario;

    String nomeEspecialista;
    String nomeUsuario;
    String dataConsulta;
    String horaConsulta;
    String idEspecialista;
    String idUsuario;
    String idHoraConsulta;
    String emailEspecialista;
    String senhaEspecialista;
    boolean  consultaMarcada;
    String emailUsuario;

    public Consulta(){
    }


    public Consulta( String emailUsuario,String emailEspecialista, String senhaEspecialista,boolean consultaMarcada,String idHoraConsulta,String idUsuario,String idConsulta,String idEspecialista, String nomeEspecialista, String nomeUsuario, String dataConsulta, String horaConsulta) {
        this.emailUsuario = emailUsuario;
        this.idConsulta = idConsulta;
        this.nomeEspecialista = nomeEspecialista;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.idEspecialista = idEspecialista;
        this.idHoraConsulta = idHoraConsulta;
        this.consultaMarcada = consultaMarcada;
        this.emailEspecialista = emailEspecialista;
        this.senhaEspecialista = senhaEspecialista;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailEspecialista() {
        return emailEspecialista;
    }

    public void setEmailEspecialista(String emailEspecialista) {
        this.emailEspecialista = emailEspecialista;
    }

    public String getSenhaEspecialista() {
        return senhaEspecialista;
    }

    public void setSenhaEspecialista(String senhaEspecialista) {
        this.senhaEspecialista = senhaEspecialista;
    }

    public boolean isConsultaMarcada() {
        return consultaMarcada;
    }

    public void setConsultaMarcada(boolean consultaMarcada) {
        this.consultaMarcada = consultaMarcada;
    }

    public String getIdHoraConsulta() {
        return idHoraConsulta;
    }

    public void setIdHoraConsulta(String idHoraConsulta) {
        this.idHoraConsulta = idHoraConsulta;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNomeEspecialista() {
        return nomeEspecialista;
    }

    public void setNomeEspecialista(String nomeEspecialista) {
        this.nomeEspecialista = nomeEspecialista;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(String idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
/* public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public DiasDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiasDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Hora getHoraDaConsulta() { return horaDaConsulta; }

    public void setHoraDaConsulta(Hora horaDaConsulta) {
        this.horaDaConsulta = horaDaConsulta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
*/

    public String consultaMarcada(Consulta consulta){


        return String.valueOf(consulta);

    }

}
