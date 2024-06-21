package pe.com.cibertec.ProyectoPolleriaApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Usuario;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.UsuarioDTO;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "rolDTO", source = "rol")
    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);
    @Mapping(target = "rol", source = "rolDTO")
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listaUsuarioAUsuarioDTO(List<Usuario> listaUsuario);
}
