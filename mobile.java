/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WP;


import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelo.Item_Cardapio;
import modelo.Cardapio;

/**
 * REST Web Service
 *
 * @author Pichau
 */
@Path("webservice")
public class mobile {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of mobile
     */
    public mobile() {
    }

    /**
     * Retrieves representation of an instance of WP.mobile
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "olaaaa";
    }
    
    
    @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listItens()
    {
        List<Item_Cardapio> lista = new ArrayList<Item_Cardapio>();
        
        Item_Cardapio u = new Item_Cardapio();
        u.nome_item="abacaxi";
        u.descr="aosd";
        u.preco="chus";
        u.gluten="jdfsh";
        u.calorias="dhjsgf";
        u.imagem="ioasd";
        
        lista.add(u);
        

        u = new Item_Cardapio();
        u.nome_item="banana";
        u.descr="ola";
        u.preco="chus";
        u.gluten="jdfsh";
        u.calorias="dhjsgf";
        u.imagem="ioasd";
        
        lista.add(u);
        
        Cardapio item = new Cardapio(lista);
        
        Gson g = new Gson();
        return g.toJson(item);
        
    }
    

    /**
     * PUT method for updating or creating an instance of mobile
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
