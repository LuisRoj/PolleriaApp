package pe.com.cibertec.ProyectoPolleriaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Rol;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Usuario;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.UsuarioRol;
import pe.com.cibertec.ProyectoPolleriaApp.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setIdrol(2);
        rol.setNombre("Cliente");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }


    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
