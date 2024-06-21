package pe.com.cibertec.ProyectoPolleriaApp.service;

import pe.com.cibertec.ProyectoPolleriaApp.model.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);
    String login(String email, String password);

    UsuarioDTO findByEmail(String email);
}

