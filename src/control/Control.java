/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import agentes.FabricaAgentes;
import blackboard.Blackboard;
import com.google.gson.Gson;
import modelo.Usuario;

/**
 *
 * @author Equipo 6
 */
public class Control {
    
    private final Blackboard blackboard;
    FabricaAgentes f=new FabricaAgentes();

    public Control(Blackboard blckboard) {
        this.blackboard = blckboard;
    }
        
    public String getAgente() {
        String accion = blackboard.getJson().substring(0, 3);
        Gson gson=new Gson();
        String mensaje="";
        String u = null;

        if(accion.equalsIgnoreCase("reg")){
            u = blackboard.getJson().substring(3, blackboard.getJson().length()); 

            Usuario usuario = new Usuario();            
            usuario = gson.fromJson(u, Usuario.class);

            String registro = f.getrAgenteUsuario().registrarUsuario(usuario);

            if(registro.equalsIgnoreCase("si")){
                mensaje = blackboard.getJson();
            }
        }
        else if(accion.equals("ini")) {
            u = blackboard.getJson().substring(3, blackboard.getJson().length()); 
            Usuario usuario = gson.fromJson(u, Usuario.class);
            Usuario s = null;
            if (usuario.getCelular() == null) {
                s = f.getrAgenteUsuario().iniciarSesionEmail(usuario.getEmail(),
                        usuario.getContrasena());
            }
            else if (usuario.getEmail() == null) {
                s = f.getrAgenteUsuario().inciarSesionCelular(usuario.getCelular(),
                        usuario.getContrasena());
            }

            mensaje = gson.toJson(s);
            
        }
        else if(accion.equals("act")){
            u = blackboard.getJson().substring(3, blackboard.getJson().length()); 
            Usuario usuario = gson.fromJson(u, Usuario.class);
            Usuario usuariobd = f.getrAgenteUsuario().consultarUsuario(usuario);
            
            usuariobd.setNombre(usuario.getNombre());
            usuariobd.setFechaNac(usuario.getFechaNac());
            usuariobd.setEdad(usuario.getEdad());
            usuariobd.setSexo(usuario.getSexo());
                       
            f.getrAgenteUsuario().actualizarUsuario(usuariobd);
            
        }

        return mensaje; 
    }

}
