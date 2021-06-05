/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pichau
 */
public class Cardapio {
    List<Item_Cardapio>list=new ArrayList<>();
    
    public Cardapio(List<Item_Cardapio>list){
        this.list=list;
    }
    
}
