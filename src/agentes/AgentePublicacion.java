/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import dao.ControlDAO;
import dao.PublicacionDAO;
import modelo.Publicacion;
import interfaces.PublicacionInterface;
import java.util.ArrayList;

/**
 *
 * @author Zarith
 */
public class AgentePublicacion implements PublicacionInterface {

    private ControlDAO c=new ControlDAO();
    private PublicacionDAO publicaciones = c.getPublicacionDAO();

    public AgentePublicacion() {
         publicaciones = c.getPublicacionDAO();
    }
    
    @Override
    public String guardarPublicacion(Publicacion publicacion) {
        String msj = publicaciones.guardarPublicacion(publicacion);
        return msj;
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publicacion> consultarPublicacion(String etiqueta) {
        System.out.println(publicaciones.consultarPublicacion(etiqueta));
        return publicaciones.consultarPublicacion(etiqueta);
    }
    
}
