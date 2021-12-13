/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Equipo 6
 */
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames={"email, celular"}))
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasena, String celular, String sexo, Date fechaNac, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.celular = celular;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.edad = edad;
    }

    public Usuario(String nombre, String email, String contrasena, String sexo, Date fechaNac, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.edad = edad;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
     int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "nombre", nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name = "email", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Column(name = "celular", nullable = true)
    private String celular;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    @Column(name = "sexo", nullable = false)
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Column(name = "fechaNac", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date fechaNac;

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    @Column(name = "edad", nullable = false)
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    private List<Publicacion> publicacionList;

    public List<Publicacion> getPublicacionList() {
        return publicacionList;
    }

    public void setPublicacionList(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
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
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", contrasena=" + contrasena + ", celular=" + celular + ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", edad=" + edad + ", publicacionList=" + publicacionList + '}';
    }

}
