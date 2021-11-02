package com.example.direitopenal;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.view.ActionMode;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult;

public class DireitoListFragment extends ListFragment {


    ArrayAdapter mAdapter;
    Direito direito = new Direito();
    List<Direito> mDireito;
    DireitoTask mTask;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mDireito = new ArrayList<>();
            }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if (mDireito == null) {
            mDireito = new ArrayList<Direito>();

            }

            mAdapter = new ArrayAdapter(getActivity(),R.layout.list_item_direito,mDireito);
            setListAdapter(mAdapter);

            if (mTask == null) {
                mTask = new DireitoTask();
                mTask.execute();
            } else {
                if (mTask.getStatus() == AsyncTask.Status.RUNNING) {
                    // Exibir um progress...
                }
            }

        }

      public class DireitoTask extends AsyncTask<Void, Void, List<Direito>> {


        @Override
        protected List<Direito> doInBackground(Void... voids) {
            try {

                HttpURLConnection conexao = DireitoHttp.abrirConexao();

                if (conexao.getResponseCode() == HttpURLConnection.HTTP_OK) {
 // caso queiro colocar outra classe json, criar o lerItems2
                    return DireitoHttp.lerItems(conexao.getInputStream());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

          @Override
          protected void onPostExecute(List<Direito> result) {
              super.onPostExecute(result);

              mAdapter.clear();
              mAdapter.addAll(result);
              mAdapter.notifyDataSetChanged();


          }
      }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
              Activity activity = getActivity();



        if (activity instanceof AoClicarDireito) {

            direito=(Direito) l.getItemAtPosition(position);
            AoClicarDireito listiner = (AoClicarDireito)activity;

            listiner.clicouDireito(direito);

    }


    }



}
