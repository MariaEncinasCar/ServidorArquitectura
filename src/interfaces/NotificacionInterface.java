/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Notificacion;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Equipo 6
 */
public interface NotificacionInterface {
    
    public void enviarCorreo(Notificacion notificacion);
    
    public void enviarTelefono(Notificacion notificacion);
    
    public List<Notificacion> consultarNotificaciones(Usuario usuario);
}
