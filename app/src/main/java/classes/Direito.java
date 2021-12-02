package classes;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONObject;

import java.io.Serializable;

public class Direito implements Serializable {

    private Long _id;
    private String assunto;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    private String dicas;
    private String conteudo;



    public Direito(String assunto, String conteudo, String dicas) {
        super();

        this.assunto =  assunto;
        this.dicas =  dicas;
        this.conteudo =  conteudo;
    }



    public Direito() {

    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDicas() {
        return dicas;
    }

    public void setDicas(String dicas) {
        this.dicas = dicas;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return assunto;
    }



}

