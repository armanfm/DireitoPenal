package com.example.direitopenal;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExcludenteFragment extends ListFragment {
    ArrayAdapter mAdapter;
    Direito direito = new Direito();
    List<Direito> mDireito;
    Adapter adapter;



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mDireito = new ArrayList<>();




    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDireito = carregarAsuntos();

        mAdapter = new ArrayAdapter<Direito>
                (getActivity(),
                        R.layout.list_item_direito,
                        mDireito);

        setListAdapter(mAdapter);

    }
    private List<Direito> carregarAsuntos() {
        mDireito = new ArrayList<Direito>();

        mDireito.add(new Direito("DOLO E CULPA","https://www.youtube.com/watch?v=o7YxGXX7C1A&t=116s"));

        mDireito.add(new Direito("CRIME DOLOSO", "https://www.youtube.com/watch?v=b7ngyN9SqLo&t=6s"));
        mDireito.add(new Direito("CULPA CONSCIENTE E INCONSCIENTE", "https://www.youtube.com/watch?v=rUJiwJm7QaE"));

        mDireito.add(new Direito("MODALIDADES DA CULPA", "https://www.youtube.com/watch?v=Iq3vFUS-XMc&t=18s"));
        mDireito.add(new Direito("CRIME PRETERDOLOSO", "https://www.youtube.com/watch?v=Lps_3RFKF3g&t=300s"));



        return mDireito;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();



        if (activity instanceof AoClicarDireito) {

            direito = (Direito) l.getItemAtPosition(position);
            AoClicarDireito listiner = (AoClicarDireito) activity;

            listiner.clicouDireito(direito);


        }

    }
}