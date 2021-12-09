/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Comentario;
import dominio.Publicacion;
import java.util.List;

/**
 *
 * @author Equipo 6 
 */
public interface ComentarioInterface {
    
    public void guardarComentario(Comentario comentario);
    
    public void eliminarComentario(Comentario comentario);
    
    public List<Comentario> consultarComentarios(Publicacion publicacion); 
}
