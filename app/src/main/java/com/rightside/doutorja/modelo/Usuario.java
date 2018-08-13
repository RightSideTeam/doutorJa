package com.rightside.doutorja.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

    private Integer id;
    private String nome;
    private String email;
    private String dataDeNascimento;
    private String senha;
    private String confirmaSenha;
    private String telefone;


    private Consulta listaDeConsultas;


    public Usuario() {

    }



    public Usuario(Integer id, String nome, String email, String dataDeNascimento, String senha, String confirmaSenha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.telefone = telefone;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getConfirmaSenha() { return confirmaSenha; }

    public void setConfirmaSenha(String confirmaSenha) { this.confirmaSenha = confirmaSenha; }

    public Consulta getListaDeConsultas() {
        return listaDeConsultas;
    }

    public void setListaDeConsultas(Consulta listaDeConsultas) {
        this.listaDeConsultas = listaDeConsultas;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


