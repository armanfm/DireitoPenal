package com.example.direitopenal;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import java.io.Serializable;

public class DireitoDetalheActivity extends AppCompatActivity{

    public static final String EXTRA_DIREITO = "direito";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direito_detalhe);




        if(savedInstanceState== null){

            Intent intent = getIntent();
            Direito direito= (Direito) intent.getSerializableExtra(EXTRA_DIREITO);
            DireitoDetalheFragmento fragmento = DireitoDetalheFragmento.novaInstancia(direito);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragmento, DireitoDetalheFragmento.TAG_DETALHE);
            ft.addToBackStack("direito");
            ft.commit();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
