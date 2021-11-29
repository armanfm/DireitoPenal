package com.example.direitopenal;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Direito<conteudo> implements Serializable  {

    private String assunto;
   // String nome;
    private String conteudo;





    public Direito(String assunto,  String conteudo) {
        super();

        this.assunto = assunto;
        //this.nome = nome;
        this.conteudo = conteudo;
    }

    public Direito() {


    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return assunto ;
    }
}

