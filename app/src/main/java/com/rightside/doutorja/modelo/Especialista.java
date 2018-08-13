package com.rightside.doutorja.modelo;


import java.io.Serializable;

public class Especialista implements Serializable {

    private String idEspecialista;

    private String email;

    private String senha;

    private String nome;


    private String especialidadeEspecialista;

    private String enderecoEspecialista;

    private String anoDeFormacao;

    private String registroProfissional;

    private String telefone;

    private double valorDoAtendimento;

    private int imagemPerfil;

    public Especialista(){}


    public Especialista(String email,String senha,String idEspecialista,String nome, String especialidadeEspecialista, String enderecoEspecialista, String anoDeFormacao, String registroProfissional,String telefone, double valorDoAtendimento, int imagemPerfil) {
        this.idEspecialista = idEspecialista;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.especialidadeEspecialista = especialidadeEspecialista;
        this.registroProfissional = registroProfissional;
        this.anoDeFormacao = anoDeFormacao;
        this.enderecoEspecialista = enderecoEspecialista;
        this.telefone = telefone;
        this.valorDoAtendimento = valorDoAtendimento;
        this.imagemPerfil = imagemPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Especialista(String coren1_xxxxx, String s, String xxxxxx, String s1, int i, int pessoa) {
    }

    public String getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(String idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getEnderecoEspecialista() {
        return enderecoEspecialista;
    }

    public void setEnderecoEspecialista(String enderecoEspecialista) {
        this.enderecoEspecialista = enderecoEspecialista;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getAnoDeFormacao() {
        return anoDeFormacao;
    }

    public void setAnoDeFormacao(String anoDeFormacao) {
        this.anoDeFormacao = anoDeFormacao;
    }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getValorDoAtendimento() {
        return valorDoAtendimento;
    }

    public void setValorDoAtendimento(double valorDoAtendimento) {
        this.valorDoAtendimento = valorDoAtendimento;
    }

    public int getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(int imagemPerfil) {

        this.imagemPerfil = imagemPerfil;
    }

    public boolean desmarcaConsulta(){

        return true;
    }

    public String getEspecialidadeEspecialista() {
        return especialidadeEspecialista;
    }

    public void setEspecialidadeEspecialista(String especialidadeEspecialista) {
        this.especialidadeEspecialista = especialidadeEspecialista;
    }


}




