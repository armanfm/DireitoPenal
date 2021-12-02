package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import classes.Direito;

public class DireitoDAO implements IDireitoDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public DireitoDAO(Context context){
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Direito direito) {
        ContentValues cv = new  ContentValues();
        cv.put("_id",  direito.get_id());
        cv.put("dicas",  direito.getDicas());
       // cv.put("assunto",  direito.getAssunto());
       // cv.put("conteudo",  direito.getConteudo());


        try {
            Log.i("INFO_DB", "dica salva com sucesso");
            escreve.insert("DIREITO", null, cv);
        }catch (Exception e){
            Log.i("INFO_DB", "erro ao salvar tabela" + e.getMessage());
            return  false;
        }



        return true;
    }

    @Override
    public boolean deletar(Direito direito) {
        return false;
    }

    @Override
    public boolean alterar(Direito direito) {
        return false;
    }

    @Override
    public List<Direito> listar() {
        List<Direito> direitos = new ArrayList<>();
        String sql = "SELECT dicas FROM DIREITO"+";";
        Cursor c = ler.rawQuery(sql, null);

        while (c.moveToNext()) {
            Direito direito = new Direito();

           // long id = c.getLong(c.getColumnIndexOrThrow("_id"));
          //  String assunto = c.getString(c.getColumnIndexOrThrow("assunto"));
          //  String conteudo = c.getString(c.getColumnIndexOrThrow("conteudo"));
            String dicas = c.getString(c.getColumnIndexOrThrow("dicas"));

            direitos.add(direito);
          //  direito.set_id(id);
            direito.setDicas(dicas);


        }


      return direitos;

    }
}
