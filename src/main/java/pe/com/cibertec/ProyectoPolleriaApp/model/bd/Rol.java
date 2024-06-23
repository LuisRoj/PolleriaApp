package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    // Constructor vacío y constructor con parámetros
    public Rol(){

    }

    public Rol(Integer rolId, String nombre) {
        this.idrol = rolId;
        this.nombre = nombre;
    }
    // Getters y setters
    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}



