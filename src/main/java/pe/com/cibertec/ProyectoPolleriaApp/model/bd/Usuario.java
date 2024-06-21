package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private String estado;
    @ManyToOne()
    @JoinColumn(name = "idrol")
    private Rol rol;
}
