package com.example.direitopenal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.net.MalformedURLException;
import java.net.URL;

public class DireitoDetalheFragmento extends Fragment {
    public static final String TAG_DETALHE = "tagDetalhe";
    private  static final String EXTRA_DIREITO = "direito";

    TextView mTextAssunto;
   // TextView mTextNome;
    Button mTextConteudo;
    Direito mDireito;






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

               View layout = inflater.inflate(R.layout.fragmento_detalhe_direito,container, false);

                mTextAssunto =(TextView)layout.findViewById(R.id.txtAssunto);
                mTextConteudo = (Button) layout.findViewById(R.id.txtConteudo);

               if (mDireito != null){
                   mTextAssunto.setText(mDireito.assunto);
                   mTextConteudo.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           getUrl(mDireito.conteudo);
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


