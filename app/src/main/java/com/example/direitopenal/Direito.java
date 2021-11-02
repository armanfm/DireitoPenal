package com.example.direitopenal;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Direito<conteudo> implements Serializable  {

    String assunto;
   // String nome;
    String conteudo;





    public Direito(String assunto,  String conteudo) {
        super();

        this.assunto = assunto;
        //this.nome = nome;
        this.conteudo = conteudo;
    }

    public Direito() {


    }


    @Override
    public String toString() {
        return assunto ;
    }
}

