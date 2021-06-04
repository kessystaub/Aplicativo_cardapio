package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    final static String dbname = "student2.db";
    final String tableName = "studentRecord2";

    public DbHelper(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tableName+" (nome_item text,descr text,preco text,gluten text,calorias text,imagem text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean saveData(String nome_item,String descr,String preco,String gluten,String calorias,String imagem){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put("nome_item",nome_item);
        contentvalues.put("descr",descr);
        contentvalues.put("preco",preco);
        contentvalues.put("gluten",gluten);
        contentvalues.put("calorias",calorias);
        contentvalues.put("imagem",imagem);

        long result = sqLiteDatabase.insert(tableName,null,contentvalues);

        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor ViewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+tableName,null);

        return cursor;
    }
}