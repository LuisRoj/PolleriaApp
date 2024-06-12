package pe.com.cibertec.ProyectoPolleriaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.ProyectoPolleriaApp.mappers.PedidoMapper;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDTO;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDetalleDTO;
import pe.com.cibertec.ProyectoPolleriaApp.repository.PedidoDetalleRepository;
import pe.com.cibertec.ProyectoPolleriaApp.repository.PedidoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public PedidoDTO crearPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.pedidoDTOAPedido(pedidoDTO);

        // Establecer la relación entre los detalles del pedido y el pedido principal
        for (PedidoDetalle detalle : pedido.getDetalles()) {
            detalle.setPedido(pedido);
        }

        // Guardar el pedido y sus detalles asociados en la base de datos
        pedido = pedidoRepository.save(pedido);

        // Devolver el pedido creado
        return pedidoMapper.pedidoAPedidoDTO(pedido);
    }

    @Override
    public PedidoDTO obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id)
                .map(pedidoMapper::pedidoAPedidoDTO)
                .orElse(null);
    }

    @Override
    public List<PedidoDTO> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::pedidoAPedidoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO actualizarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.pedidoDTOAPedido(pedidoDTO);

        // Establecer la relación entre los detalles del pedido y el pedido principal
        for (PedidoDetalle detalle : pedido.getDetalles()) {
            detalle.setPedido(pedido);
        }

        // Guardar el pedido actualizado y sus detalles asociados en la base de datos
        pedido = pedidoRepository.save(pedido);

        // Devolver el pedido actualizado
        return pedidoMapper.pedidoAPedidoDTO(pedido);
    }

    @Override
    public void eliminarPedido(int id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<PedidoDetalleDTO> obtenerDetallesPorIdPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            return pedido.getDetalles().stream()
                    .map(pedidoMapper::pedidoDetalleAPedidoDetalleDTO)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
