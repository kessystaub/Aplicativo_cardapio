/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Item_Cardapio;

/**
 *
 * @author Pichau
 */
public class UsuarioDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public UsuarioDAO()
    {
    
    }
    
    public boolean inserir(Item_Cardapio usuario)
    {
        String sql = "INSERT INTO usuario(login,senha,perfil,email) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            //pst.setString(1, usuario.getLogin());
            //pst.setString(2, usuario.getSenha());
            //p/st.setString(3, usuario.getPerfil());
            //pst.setString(4, usuario.getEmail());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Item_Cardapio usuario)
    {
        String sql = "UPDATE usuario set senha=?,perfil=?,email=? where login=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            //pst.setString(1, usuario.getSenha());
            //pst.setString(2, usuario.getPerfil());
            //pst.setString(3, usuario.getEmail());
            //pst.setString(4, usuario.getLogin());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Item_Cardapio usuario)
    {
        String sql = "DELETE FROM usuario where login=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            //pst.setString(1, usuario.getLogin());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Item_Cardapio> listar()
    {
         String sql = "SELECT * FROM usuario";
        List<Item_Cardapio> retorno = new ArrayList<Item_Cardapio>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
               /// Item_Cardapio item = new Item_Cardapio();
//.setSenha(res.getString("senha"));
                //item.setEmail(res.getString("email"));
                ///i/tem.setPerfil(res.getString("perfil"));
                
                //retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Item_Cardapio buscar(Item_Cardapio usuario)
    {
         String sql = "SELECT * FROM usuario where login=?";
        Item_Cardapio retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            //pst.setString(1, usuario.getLogin());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Item_Cardapio();
               // retorno.setLogin(res.getString("login"));
                //retorno.setSenha(res.getString("senha"));
               // retorno.setEmail(res.getString("email"));
                //retorno.setPerfil(res.getString("perfil"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
