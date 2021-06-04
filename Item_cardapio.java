package com.example.myproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Item_cardapio {
    public String nome_item;
    public String descr;
    public String preco;
    public String gluten;
    public String calorias;
    public String imagem;

    public Item_cardapio(String nome_item, String descr, String preco, String gluten, String calorias, String imagem) {
        this.nome_item = nome_item;
        this.descr = descr;
        this.preco = preco;
        this.gluten = gluten;
        this.calorias = calorias;
        this.imagem = imagem;
    }
}
