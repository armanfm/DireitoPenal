package com.example.direitopenal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.direitopenal.DireitoDetalheActivity;
import com.example.direitopenal.DireitoListFragment;
import com.example.direitopenal.R;

import java.util.ArrayList;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
import classes.Direito;

public class AdapterList extends ArrayAdapter<Direito> {

    DireitoListFragment activity;
    Direito mDireito = new Direito();


    EditText edtar;
    Button salvar;
    DireitoDetalheActivity da;
    DireitoDetalheActivity mActivity;
    ListView mLista;
    ViewHolder vh;
    List<Direito> listaDireito = new ArrayList<>();
    RecyclerView recyclerView;

    TextView dicas;
    EditText escreverDica;
    ImageButton adcDica;

    public AdapterList(@NonNull Context context, List<Direito> resource) {
        super(context, 0, resource);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Direito direito = (Direito) getItem(position);


        if (convertView == null) {

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.fragmento_detalhe_direito, null);


            vh.txtAssunto2.setText(direito.getAssunto());
            TextView conteudo = (TextView) convertView.findViewById(R.id.txtConteudo);
            edtar = (EditText) convertView.findViewById(R.id.txtAnotaçoes);


            //lista tarefa


            //exibir lista de tarefas no reclycleview


            //adapter
          //  AdapterDicas adapterDicas = new AdapterDicas(listaDireito);
            recyclerView = (RecyclerView) convertView.findViewById(R.id.listaDicas);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.addItemDecoration(new DividerItemDecoration
                    (getContext().getApplicationContext(), LinearLayout.VERTICAL));
           // recyclerView.setAdapter(adapterDicas);


            conteudo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getUrl(direito.getConteudo());
                }
            });

        }
        return convertView;

    }

    private void getUrl(String conteudo) {

        Uri url = Uri.parse(conteudo);
        activity.startActivity(new Intent(Intent.ACTION_VIEW, url));

    }

    static class ViewHolder {
        @Bind(R.id.txtAssunto)
        TextView txtAssunto2;


        public ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
        }
    }


}