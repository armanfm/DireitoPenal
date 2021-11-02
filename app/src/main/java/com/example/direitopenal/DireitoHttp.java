package com.example.direitopenal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DireitoHttp {

    // conectando a internet
    public static HttpURLConnection abrirConexao() throws IOException {




        URL url = new URL("https://raw.githubusercontent.com/armanfm/-username-.github.io-/main/infra%C3%A7%C3%A3o.json");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        conexao.connect();
        return conexao;
    }
    // verificando conexãp
    public static boolean hasConnection(final Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNW = cm.getActiveNetworkInfo();
        if (activeNW != null && activeNW.isConnected())
        {
            return true;
        }
        return false;
    }
    public static List<Direito> lerItems(InputStream is)
            throws JSONException, IOException {
        List<Direito> mDireito= new ArrayList<Direito>();

        JSONObject json = new JSONObject(bytesToString(is));
        JSONArray jsonItems = json.getJSONArray("Infração Penal");

        for (int i = 0; i < jsonItems.length(); i++) {
            JSONObject jsonDireito= jsonItems.getJSONObject(i);
            Direito direito = new Direito(

                    jsonDireito.getString("assunto"),
                    jsonDireito.getString("conteudo"));


            mDireito.add(direito);

        }
        return mDireito;


    }


    private static String bytesToString(InputStream is) throws IOException {

        byte[] bufferzinho = new byte[1024];
        ByteArrayOutputStream bufferzao = new ByteArrayOutputStream();
        int bytesLidos;
        while ((bytesLidos = is.read(bufferzinho)) != -1){
            bufferzao.write(bufferzinho, 0, bytesLidos);
        }
        return new String(bufferzao.toByteArray());
    }



}



