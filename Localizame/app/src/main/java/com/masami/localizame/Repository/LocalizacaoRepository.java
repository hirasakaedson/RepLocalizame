package com.masami.localizame.Repository;


import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.masami.localizame.Models.Localizacao;
import java.util.ArrayList;
import java.util.List;

public class LocalizacaoRepository
{
    private Context _Context;
    ConexaoBanco conexaoBanco;
    SQLiteDatabase db;
    public static final String LOCALIZACAO_REPOSITORY_SCRIPT="CREATE TABLE localizacao (\n" +
            "    idLocalizacao   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "                            NOT NULL,\n" +
            "    longitude       TEXT    NOT NULL,\n" +
            "    latitude        TEXT    NOT NULL,\n" +
            "    dataLocalizacao TEXT    NOT NULL,\n" +
            ");\n";
    private static final String NOME_TABELA="localizacao";
    private static final String[] COLUNAS=new String[]{"idLocalizacao","longitude","latitude","data"};



    public  LocalizacaoRepository (Context context)
    {
        _Context=context;
        conexaoBanco=new ConexaoBanco(context);
        db=conexaoBanco.getWritableDatabase();
    }
    public long Insert(Localizacao localizacao)
    {
        try {
        ContentValues contentValues=getContentValues(localizacao);
        long Id=db.insert(NOME_TABELA,null,contentValues);
        return Id;
        }
        catch(SQLException erro)
        {
            Toast.makeText(_Context,"ERRO AO INSERIR"+ erro.getMessage(),Toast.LENGTH_LONG).show();
            return 0;
        }
        finally {
            db.close();
        }
    }
    public int Update(Localizacao localizacao)
    {
        try{
            return db.update(NOME_TABELA,getContentValues(localizacao),"idLocalizacao=?",new String[]{String.valueOf(localizacao.getId())});
        }
        catch (SQLException erro)
        {
            Toast.makeText(_Context,"ERRO AO ATULIZAR" + erro.getMessage(),Toast.LENGTH_LONG).show();
            return 0;
        }
        finally {
            db.close();
        }
    }
    public int Delete(int Id)
    {
        try{
            return db.delete(NOME_TABELA,"idLocalizacao=?",new String[]{String.valueOf(Id)});
        }
        catch(SQLException erro){
            Toast.makeText(_Context,"ERRO AO DELETAR"+erro.getMessage(),Toast.LENGTH_LONG).show();
            return 0;
        }
        finally {
            db.close();
        }
    }
    public Localizacao SelectID(int Id)
    {
        try{
            Cursor cursor=db.query(NOME_TABELA,COLUNAS,"idLocalizacao=?",new String[]{String.valueOf(Id)},null,null,"dataLocalizacao");
            if (cursor.moveToFirst()){
                Localizacao localizacao=setLocalizacaoValues(cursor);
                return localizacao;
            }
            return null;
        }
         catch (SQLException erro)
        {
            Toast.makeText(_Context, "ERRO AO BUSCAR POR ID" + erro.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
            finally {
        db.close();
    }
    }
    public Cursor SelectTodos_Cursor(){
        return db.query(NOME_TABELA,COLUNAS,null,null,null,null,"dataLocalizacao");
    }


    private ContentValues getContentValues(Localizacao localizacao) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("idLocalizacao",localizacao.getId());
        contentValues.put("longitude",localizacao.getLongitude());
        contentValues.put("latitude",localizacao.getLatitude());
        contentValues.put("dataLocalizacao",localizacao.getDataLocalizacao());
        return contentValues;
    }
    private Localizacao setLocalizacaoValues(Cursor cursor){
        Localizacao localizacao=new Localizacao();
        localizacao.setId(cursor.getInt(cursor.getColumnIndex("idLocalizacao")));
        localizacao.setLongitude(cursor.getFloat(cursor.getColumnIndex("longitude")));
        localizacao.setLatitude(cursor.getFloat(cursor.getColumnIndex("latitude")));
      localizacao.setDataLocalizacao(cursor.getString(cursor.getColumnIndex("dataLocalizacao")));
        return localizacao;
    }
}
