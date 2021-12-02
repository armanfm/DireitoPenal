package adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.direitopenal.R;

import java.util.List;

import classes.Direito;

public class AdapterDica extends  RecyclerView.Adapter<AdapterDica.myViewHolder>{


    List<Direito> listaDica;

    public AdapterDica(List<Direito> lista) {
        this.listaDica = lista;

    }

    public AdapterDica() {

    }

    @NonNull
    @Override
    public AdapterDica.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,
                viewGroup, false);

        return new myViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        Direito direito = listaDica.get(i);

        myViewHolder.dicas.setText(direito.getDicas());


    }


    @Override
    public int getItemCount() {

        return listaDica.size();
    }




    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView dicas;
        EditText inserirDicas;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            dicas = itemView.findViewById(R.id.txtDicas);
            inserirDicas = itemView.findViewById(R.id.txtEditar);


        }
    }
}
