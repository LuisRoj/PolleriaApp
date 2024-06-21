package pe.com.cibertec.ProyectoPolleriaApp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.cibertec.ProyectoPolleriaApp.mappers.UsuarioMapper;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Usuario;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.UsuarioDTO;
import pe.com.cibertec.ProyectoPolleriaApp.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.instancia.usuarioDTOAUsuario(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario savedUser = usuarioRepository.save(usuario);
        return UsuarioMapper.instancia.usuarioAUsuarioDTO(savedUser);
    }

    @Override
    public String login(String email, String password) {
        Optional<Usuario> userOptional = usuarioRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return "Inicio de sesión exitosa";
            }
        }
        return "Email o contraseña incorrecta";
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.map(UsuarioMapper.instancia::usuarioAUsuarioDTO).orElse(null);
    }
}

