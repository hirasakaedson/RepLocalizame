package com.masami.localizame.Repository;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoBanco extends SQLiteOpenHelper {
    private static final String Nome_Banco = "DB_LOCALIZEME";
    private static final int VERSAO = 1;
    private Context _context;
    public ConexaoBanco(Context context)
    {
        super(context,Nome_Banco,null,VERSAO);
        _context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LocalizacaoRepository.LOCALIZACAO_REPOSITORY_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
