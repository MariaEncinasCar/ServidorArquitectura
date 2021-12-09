/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Comentario;
import dominio.Publicacion;
import interfaces.ComentarioInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Equipo 6 
 */
public class ComentarioDAO implements ComentarioInterface{
    
    EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("faceboot_ServidorPU");
    EntityManager em = emFactory.createEntityManager();
    
    @Override
    public void guardarComentario(Comentario comentario) {
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        em.getTransaction().begin();
        em.remove(comentario);
        em.getTransaction().commit();
    }

    @Override
    public List<Comentario> consultarComentarios(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
