package pe.com.cibertec.ProyectoPolleriaApp.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDTO;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDetalleDTO;

@Mapper
public interface PedidoMapper {

    PedidoMapper instancia = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO pedidoAPedidoDTO(Pedido pedido);

    Pedido pedidoDTOAPedido(PedidoDTO pedidoDTO);

    PedidoDetalleDTO pedidoDetalleAPedidoDetalleDTO(PedidoDetalle pedidoDetalle);

    PedidoDetalle pedidoDetalleDTOAPedidoDetalle(PedidoDetalleDTO pedidoDetalleDTO);
}
