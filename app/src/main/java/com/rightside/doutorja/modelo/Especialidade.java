package com.rightside.doutorja.modelo;

import java.io.Serializable;

public class Especialidade implements Serializable {

    private String nome;

    private int imagem;

    private int idEspecialidade;

    public Especialidade() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}
