/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Publicacion;
import java.util.ArrayList;

/**
 *
 * @author Equipo 6
 */
public interface PublicacionInterface {
    
    public String guardarPublicacion(Publicacion publicacion);
    
    public void eliminarPublicacion(Publicacion publicacion);
    
    public ArrayList<Publicacion> consultarPublicacion(String etiqueta); 
    
}
