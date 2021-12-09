/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;
import interfaces.UsuarioInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Equipo 6 
 */
public class UsuarioDAO implements UsuarioInterface {
    
    EntityManagerFactory emFactory = Persistence
            .createEntityManagerFactory("faceboot_ServidorPU");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public String registrarUsuario(Usuario usuario) {
        String mensaje="no";
        
        if(this.comprobarUnique(usuario)){
            em.getTransaction().begin();
            em.persist(usuario);
            mensaje="si";
            em.getTransaction().commit();
        }   
        
        return mensaje;
    }
    
    public boolean comprobarUnique(Usuario usuario){
        
        em.getTransaction().begin();

        String consulta = "SELECT v FROM Usuario v WHERE v.email LIKE :email OR "
                + "v.celular LIKE :celular";

        TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);

        if (usuario.getCelular() != null) {
            query.setParameter("email", "%" + usuario.getEmail() + "%");
            query.setParameter("celular", "%" + usuario.getCelular() + "%");
        }else{
            query.setParameter("email", "%" + usuario.getEmail() + "%");
            query.setParameter("celular", "%" + usuario.getEmail() + "%");
        }

        List<Usuario> usuarios = query.getResultList();

        em.getTransaction().commit();
        return usuarios.isEmpty();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        em.getTransaction().begin();
        Usuario u = em.find(Usuario.class, usuario.getId());
        
        u.setNombre(usuario.getNombre());
        u.setContrasena(usuario.getContrasena());
        u.setFechaNac(usuario.getFechaNac());
        u.setEdad(usuario.getEdad());
        u.setSexo(usuario.getSexo());
        em.getTransaction().commit();
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Usuario.class));
        Query query = em.createQuery(criteria);
        List<Usuario> uList = query.getResultList();
        em.getTransaction().commit();
        return uList;
    }

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        em.getTransaction().begin();
        
        String jpql = "SELECT v FROM Usuario v WHERE v.email LIKE :email";
        
        TypedQuery query = em.createQuery(jpql, Usuario.class);
                
        query.setParameter("email", "%" + usuario.getEmail()+ "%");
//        query.setParameter("nombre", "%" + usuario.getNombre()+ "%");
//        query.setParameter("celular", "%" + usuario.getCelular()+ "%");
//        query.setParameter("id_usuario", "%" + usuario.getId() + "%");
        
        Object use = query.getSingleResult();
        
        em.getTransaction().commit();
        return (Usuario) use;
    }

    @Override
    public Usuario iniciarSesionEmail(String email, String contrasena) {
        em.getTransaction().begin();

        String jpql = "SELECT v FROM Usuario v WHERE v.email = :email AND "
                + "v.contrasena = :contrasena";

        TypedQuery query = em.createQuery(jpql, Usuario.class);

        query.setParameter("email",email );
        query.setParameter("contrasena", contrasena);

        try {
            em.getTransaction().commit();
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario inciarSesionCelular(String celular, String contrasena) {
        em.getTransaction().begin();

        String jpql = "SELECT v FROM Usuario v WHERE v.celular = :celular AND "
                + "v.contrasena = :contrasena";

        TypedQuery query = em.createQuery(jpql, Usuario.class);

        query.setParameter("celular", "%" + celular + "%");
        query.setParameter("contrasena", "%" + contrasena + "%");

        try {
            em.getTransaction().commit();
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
