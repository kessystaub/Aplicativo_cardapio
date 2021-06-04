package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;
    ListView listView;

    List<Item_cardapio> itens = new ArrayList();
    Adaptador_cardapio adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        dbHelper = new DbHelper(this);

         /*
        for(int i = 0; i < 8; i++){
            if(i==0){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==1){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==2){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==3){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==4){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==5){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==6){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }else if(i==7){
                String nome_item = "";
                String descr = "";
                String preco = "";
                String gluten = "";
                String calorias = "";
                String imagem = "";
                dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);
            }
        }
          */

        String nome_item = "macarrao";
        String descr = "miojo";
        String preco = "a consultar";
        String gluten = "sim";
        String calorias = "muitas";
        String imagem = "imagen";

        boolean result = dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);

        if(result==true){
            Toast.makeText(getApplicationContext(),"Record is saved",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Record is not saved",Toast.LENGTH_SHORT).show();
        }

        showDataINListView();
        adaptador = new Adaptador_cardapio(this, (ArrayList<Item_cardapio>) itens);
        listView.setAdapter(adaptador);
    }

    void showDataINListView(){
        Cursor cursor = dbHelper.ViewData();
        while(cursor.moveToNext()) {

            String nome_item = cursor.getString(0);
            String descr = cursor.getString(1);
            String preco = cursor.getString(2);
            String gluten = cursor.getString(3);
            String calorias = cursor.getString(4);
            String imagem = cursor.getString(5);

            Item_cardapio franquia = new Item_cardapio(nome_item,descr,preco,gluten,calorias,imagem);
            itens.add(franquia);
        }
    }
}