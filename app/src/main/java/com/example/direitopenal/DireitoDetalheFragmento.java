package com.example.direitopenal;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.AdapterDica;
import classes.Direito;
import helper.DbHelper;
import helper.DireitoDAO;
import helper.RecyclerItemClickListener;

public class DireitoDetalheFragmento extends Fragment {
    public static final String TAG_DETALHE = "tagDetalhe";
    private  static final String EXTRA_DIREITO = "direito";

    TextView mTextAssunto;
    // TextView mTextNome;
    Button mTextConteudo;
    Direito mDireito = new Direito();
    RecyclerView recyclerView;
    List<Direito> listaDireito = new ArrayList<>();
    Direito direito = new Direito();





    public static DireitoDetalheFragmento novaInstancia(Direito direito) {
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_DIREITO, direito);

        DireitoDetalheFragmento fragmento = new DireitoDetalheFragmento();
        fragmento.setArguments(parametros);
        return fragmento;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDireito = (Direito) getArguments().getSerializable(EXTRA_DIREITO);

        setHasOptionsMenu(true);
        getActivity();
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        mDireito= (Direito) getArguments().getSerializable(EXTRA_DIREITO);

     //   DbHelper db = new DbHelper(getContext().getApplicationContext());
       // ContentValues cv = new ContentValues();

        //cv.put("dicas",direito.getDicas());
        //db.getWritableDatabase().insert("DIREITO",null,cv);

        View layout = inflater.inflate(R.layout.fragmento_detalhe_direito,container, false);

        mTextAssunto =(TextView)layout.findViewById(R.id.txtAssunto);
        mTextConteudo = (Button) layout.findViewById(R.id.txtConteudo);



        //RECYCLEVIEW

        //lista tarefa

        EditText escreverDica=(EditText)layout.findViewById(R.id.txtEditar);
        ImageButton adcDica =(ImageButton)layout.findViewById(R.id.imageButton);
         DireitoDAO direitoDAO = new DireitoDAO(getContext().getApplicationContext());

         listaDireito = direitoDAO.listar();
         String dicas = escreverDica.getText().toString();
         Direito direito1 = new Direito();





            adcDica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!dicas.isEmpty())

                        direito1.setDicas(dicas);

                        direitoDAO.salvar(direito1);

                    listaDireito.add(direito1);

                }


            });

        //exibir lista de tarefas no reclycleview

        //adapter
        AdapterDica adapterDica = new AdapterDica(listaDireito);


        recyclerView =layout.findViewById(R.id.carregarListaDicas);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext().getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        ));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().
                getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setHasFixedSize(true);
         recyclerView.addItemDecoration(new DividerItemDecoration(getContext().getApplicationContext(), LinearLayout.VERTICAL));
         recyclerView.setAdapter(adapterDica);



        if (mDireito != null){
            mTextAssunto.setText(mDireito.getAssunto());
            mTextConteudo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getUrl(mDireito.getConteudo());
                }
            });


        }
        return layout;

    }

    private void getUrl(String conteudo) {

        Uri url = Uri.parse(conteudo);

        startActivity(new Intent(Intent.ACTION_VIEW, url));

    }


}





