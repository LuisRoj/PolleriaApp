package pe.com.cibertec.ProyectoPolleriaApp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private int idusuario;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private int estado;
    private RolDTO rolDTO;
}
