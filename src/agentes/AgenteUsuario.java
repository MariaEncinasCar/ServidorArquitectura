/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import dao.ControlDAO;
import dao.UsuarioDAO;
import interfaces.UsuarioInterface;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Equipo 6
 */
public class AgenteUsuario implements UsuarioInterface {
    
    private ControlDAO c=new ControlDAO();
    private UsuarioDAO usuarios = c.getUsuarioDAO();

    public AgenteUsuario() {
        usuarios = c.getUsuarioDAO();
    }

    @Override
    public String registrarUsuario(Usuario usuario) {
        String msj = usuarios.registrarUsuario(usuario);
        return msj;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarios.actualizarUsuario(usuario);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> lista = usuarios.consultarUsuarios();
        return lista;
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        Usuario consulta = usuarios.consultarUsuario(usuario);
        return consulta;
    }

    @Override
    public Usuario iniciarSesionEmail(String email, String contrasenia) {
        return usuarios.iniciarSesionEmail(email, contrasenia);        
    }

    @Override
    public Usuario inciarSesionCelular(String celular, String contrasena) {
        return usuarios.inciarSesionCelular(celular, contrasena); 
    }
    
}
