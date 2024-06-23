package pe.com.cibertec.ProyectoPolleriaApp.service;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Usuario;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Integer usuarioId);

}

