/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Usuario;
import java.util.List;

/**
 *
 * @author Equipo 6 
 */
public interface UsuarioInterface {
    
    public String registrarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public List<Usuario> consultarUsuarios();
    
    public Usuario consultarUsuario(Usuario usuario);
    
    public Usuario iniciarSesionEmail(String email, String contrasena);
    
    public Usuario inciarSesionCelular(String celular, String contrasena);
}
