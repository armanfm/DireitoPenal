package helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
     public  static int VERSION = 1;
     public  static  String NOME_DB = "DB_DIREITO_PENAL_TESTE5";
   // public  static  String TABELA_DIREITO = "direito";



    public DbHelper(@Nullable Context context) {
        super(context,  NOME_DB, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

       String sql = ("create table DIREITO(_id integer primary key autoincrement  , "
               + "assunto text null , conteudo  text null, dicas text null)");

       try {
            db.execSQL(sql);
           Log.i("INFO_DB", "tabela criada com sucesso" );
       }catch (Exception e){
           Log.i("INFO_DB", "erro ao criar tabela" + e.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
