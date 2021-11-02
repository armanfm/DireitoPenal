package com.example.direitopenal;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends ArrayAdapter<Direito> {
    DireitoListFragment activity;


    public AdapterList(@NonNull Context context, List<Direito> resource) {
        super(context,0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Direito direito = (Direito) getItem(position);


        if (convertView == null) {

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_direito, null);

        TextView assunto = (TextView) convertView.findViewById(R.id.txtAssunto2);
        TextView conteudo = (TextView) convertView.findViewById(R.id.txtConteudo2);

        assunto.setText(direito.assunto);
        conteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUrl(direito.conteudo);
            }
        });


    }
               return convertView;

}

    private void getUrl(String conteudo) {

        Uri url = Uri.parse(conteudo);
        activity.startActivity(new Intent(Intent.ACTION_VIEW, url));

    }


}