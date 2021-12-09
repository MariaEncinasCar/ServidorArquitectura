/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Publicacion;
import java.util.List;

/**
 *
 * @author Equipo 6
 */
public interface PublicacionInterface {
    
    public void guardarPublicacion(Publicacion publicacion);
    
    public void eliminarPublicacion(Publicacion publicacion);
    
    public List<Publicacion> consultarPublicacion(String etiqueta); 
    
}
