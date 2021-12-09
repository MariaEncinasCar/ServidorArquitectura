/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Notificacion;
import dominio.Usuario;
import interfaces.NotificacionInterface;
import java.util.List;

/**
 *
 * @author Equipo 6
 */
public class NotificacionDAO implements NotificacionInterface{

    @Override
    public void enviarCorreo(Notificacion notificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarTelefono(Notificacion notificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notificacion> consultarNotificaciones(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
