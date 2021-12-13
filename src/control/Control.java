/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import agentes.FabricaAgentes;
import blackboard.Blackboard;
import com.google.gson.Gson;
import java.util.List;
import modelo.Publicacion;
import modelo.Usuario;

/**
 *
 * @author Equipo 6
 */
public class Control {
    
    private final Blackboard blackboard;
    FabricaAgentes fabrica = new FabricaAgentes();

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
            String registro = fabrica.getrAgenteUsuario().registrarUsuario(usuario);

            if(registro.equalsIgnoreCase("si")){
                mensaje = blackboard.getJson();
            }
        }
        else if(accion.equals("ini")) {
            u = blackboard.getJson().substring(3, blackboard.getJson().length()); 
            Usuario usuario = gson.fromJson(u, Usuario.class);
            System.out.println("Usuario " + usuario);
            Usuario s = null;
            if (usuario.getCelular() == null) {
                s = fabrica.getrAgenteUsuario().iniciarSesionEmail(usuario.getEmail(),
                        usuario.getContrasena());
                if(s!=null){
                    List<Publicacion> publicacionesUsuario=null;
                    s.setPublicacionList(publicacionesUsuario);
                }  
            }
            else if (usuario.getEmail() == null) {
                s = fabrica.getrAgenteUsuario().inciarSesionCelular(usuario.getCelular(),
                        usuario.getContrasena());
                
                if(s!=null){
                    List<Publicacion> publicacionesUsuario=null;
                    s.setPublicacionList(publicacionesUsuario);
                }  
            }
            
            mensaje = gson.toJson(s);
            
        }
        else if(accion.equals("act")){
            u = blackboard.getJson().substring(3, blackboard.getJson().length()); 
            Usuario usuario = gson.fromJson(u, Usuario.class);
            Usuario usuariobd = fabrica.getrAgenteUsuario().consultarUsuario(usuario);
            
            usuariobd.setNombre(usuario.getNombre());
            usuariobd.setFechaNac(usuario.getFechaNac());
            usuariobd.setEdad(usuario.getEdad());
            usuariobd.setSexo(usuario.getSexo());
                       
            fabrica.getrAgenteUsuario().actualizarUsuario(usuariobd);
            
        }
        else if(accion.equals("ppu")){
            u = blackboard.getJson().substring(3, blackboard.getJson().length());
            System.out.println(u);
            Publicacion publicacion = gson.fromJson(u, Publicacion.class);
            System.out.println(publicacion);

            Usuario usuariobd = fabrica.getrAgenteUsuario().consultarUsuario(publicacion.getUsuario());
            publicacion.setUsuario(usuariobd);

            fabrica.getrAgentePublicacion().guardarPublicacion(publicacion);
        }
        else if(accion.equalsIgnoreCase("opu")){
            List<Publicacion> publicacionesUsuario=null;
            
            List<Publicacion> publicaciones = fabrica.getrAgentePublicacion().consultarPublicacion("");
            for (int i = 0; i < publicaciones.size(); i++) {
                publicaciones.get(i).getUsuario().setPublicacionList(publicacionesUsuario);
            }
            mensaje = gson.toJson(publicaciones);
        }

        return mensaje; 
    }

}
