/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Zarith
 */

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {

    public Publicacion() {
        
    }

    public Publicacion(String contenidoTex, Usuario usuario, Date fechaHora) {
        this.contenidoTex = contenidoTex;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "contenidoText", nullable = false)
    private String contenidoTex;

    public String getContenidoText() {
        return contenidoTex;
    }

    public void setContenidoText(String contenidoText) {
        this.contenidoTex = contenidoText;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Column(name="fechaHora", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaHora;

    public Date getfechaHora() {
        return fechaHora;
    }

    public void setfechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", contenidoTex=" + contenidoTex + ", usuario=" + usuario + ", fechaHora=" + fechaHora + '}';
    }

    
}
