/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.PublicacionInterface;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Publicacion;

/**
 *
 * @author Equipo 6
 */
public class PublicacionDAO implements PublicacionInterface{

    EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("faceboot_ServidorPU");
    EntityManager em = emFactory.createEntityManager();
    
    @Override
    public String guardarPublicacion(Publicacion publicacion) {
        String mensaje = "no";
        em.getTransaction().begin();
        em.persist(publicacion);
        mensaje = "si";
        em.getTransaction().commit();
        return mensaje;
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publicacion> consultarPublicacion(String etiqueta) {
        ArrayList<Publicacion> lista;
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Publicacion.class));
        Query query = em.createQuery(criteria);
        List<Publicacion> sl = query.getResultList();
        lista = new ArrayList(sl);
       
        try {
            em.getTransaction().commit();
            System.out.println();
            return lista;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
