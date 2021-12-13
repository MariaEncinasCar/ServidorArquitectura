/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Zarith
 */
public class ControlDAO {
    private UsuarioDAO usuario;
    private PublicacionDAO publicacion;
    
    public UsuarioDAO getUsuarioDAO() {
        if(usuario!=null){
            return usuario;
        }else{
            usuario = new UsuarioDAO();
            return usuario;
        }
    }
    
    public PublicacionDAO getPublicacionDAO() {
        if(publicacion!=null){
            return publicacion;
        }else{
            publicacion = new PublicacionDAO();
            return publicacion;
        }
    }
}
