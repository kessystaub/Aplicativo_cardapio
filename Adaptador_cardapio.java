package com.example.myproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador_cardapio extends BaseAdapter{

        Activity contexto;
        ArrayList<Item_cardapio> itemcardapios;
        private static LayoutInflater inflater = null;

        public Adaptador_cardapio(Activity contexto, ArrayList<Item_cardapio> itemcardapios){
            this.contexto = contexto;
            this.itemcardapios = itemcardapios;
            inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return itemcardapios.size();
        }

        @Override
        public Item_cardapio getItem(int position) {
            return itemcardapios.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View visualizador = convertView;
            visualizador = (visualizador == null) ? inflater.inflate(R.layout.tela_cardapio,null): visualizador;
            TextView Nome = (TextView) visualizador.findViewById(R.id.IDNome);
            TextView Desc = (TextView) visualizador.findViewById(R.id.IDDescricao);
            TextView Preco = (TextView) visualizador.findViewById(R.id.IDPreco);
            TextView Gluten = (TextView) visualizador.findViewById(R.id.IDgluten);
            TextView Calorias = (TextView) visualizador.findViewById(R.id.IDCalorias);
            ImageView Imagem = visualizador.findViewById(R.id.IDimagem);
            Item_cardapio selectedItemcardapio = itemcardapios.get(position);
            Nome.setText(selectedItemcardapio.nome_item);
            Desc.setText(selectedItemcardapio.descr);
            Preco.setText(selectedItemcardapio.preco);
            Gluten.setText(selectedItemcardapio.gluten);
            Calorias.setText(selectedItemcardapio.calorias);
            //Imagem.setImageResource(selectedRestaurante.imagem);
            return visualizador;
        }
}
