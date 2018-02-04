package br.com.bmnv.portalaluno.app;

/**
 * Created by 16165872 on 10/04/2017.
 */

public class Fics {

    String nome;
    String status;

    public Fics(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
