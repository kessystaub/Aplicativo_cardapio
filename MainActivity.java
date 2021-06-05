package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;
    public ListView listView;

    private static String JSON_URL = "https://run.mocky.io/v3/c8491ca5-5802-4990-aaf8-6bf3d91f1e20";

    List<Item_cardapio> itens = new ArrayList();
    public Adaptador_cardapio adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        dbHelper = new DbHelper(this);


        GetData getData = new GetData();
        getData.execute();
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

        String nome_item = "mo";
        String descr = "miojo";
        String preco = "a consultar";
        String gluten = "sim";
        String calorias = "muitas";
        String imagem = "imagen";

        //boolean result = dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);

        //if(result==true){
        //    Toast.makeText(getApplicationContext(),"Record is saved",Toast.LENGTH_SHORT).show();
        //}else{
        //    Toast.makeText(getApplicationContext(),"Record is not saved",Toast.LENGTH_SHORT).show();
        //}



        showDataINListView();
        adaptador = new Adaptador_cardapio(this, (ArrayList<Item_cardapio>) itens);
        //listView.setAdapter(adaptador);
    }

    public class GetData extends AsyncTask<String,String,String>{


        @Override
        protected String doInBackground(String... strings) {

            String current = "";
            try{
                URL url;
                HttpURLConnection urlConnection = null;

                try{
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data!=-1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    if(urlConnection!=null){
                        urlConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        protected void onPostExecute(String s){

            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("list");

                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    String nome_item = jsonObject1.getString("nome_item");
                    String descr = jsonObject1.getString("descr");
                    String preco = jsonObject1.getString("preco");
                    String gluten = jsonObject1.getString("gluten");
                    String calorias = jsonObject1.getString("calorias");
                    String imagem = jsonObject1.getString("imagem");

                    dbHelper.saveData(nome_item,descr,preco,gluten,calorias,imagem);

                    listView.setAdapter(adaptador);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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

            Item_cardapio item_menu = new Item_cardapio(nome_item,descr,preco,gluten,calorias,imagem);
            itens.add(item_menu);
        }
    }
}