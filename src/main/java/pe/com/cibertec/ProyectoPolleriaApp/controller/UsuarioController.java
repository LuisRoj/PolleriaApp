package pe.com.cibertec.ProyectoPolleriaApp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.UsuarioDTO;
import pe.com.cibertec.ProyectoPolleriaApp.service.UsuarioServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUser(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO, HttpSession session) {
        String resultado = usuarioService.login(usuarioDTO.getEmail(), usuarioDTO.getPassword());

        if ("Inicio de sesión exitosa".equals(resultado)) {
            // Obtener el usuario desde la base de datos
            UsuarioDTO usuario = usuarioService.findByEmail(usuarioDTO.getEmail());

            // Manejar la autenticación manualmente (opcional dependiendo de la configuración de Spring Security)
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Guardar el ID de sesión en algún lugar (opcional, dependiendo de cómo lo necesites manejar)
            String sessionId = session.getId();

            // Construir la respuesta con los datos del usuario y el ID de sesión
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", resultado);
            response.put("usuario", usuario);
            response.put("sessionId", sessionId);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultado);
        }
    }

    @GetMapping("/usuario")
    public ResponseEntity<UsuarioDTO> getUsuario(Authentication authentication) {
        String email = authentication.getName();
        UsuarioDTO usuario = usuarioService.findByEmail(email);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


