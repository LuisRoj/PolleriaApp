package pe.com.cibertec.ProyectoPolleriaApp.service;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDTO;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDetalleDTO;

import java.util.List;

public interface IPedidoService {
    PedidoDTO crearPedido(PedidoDTO pedidoDTO);
    PedidoDTO obtenerPedidoPorId(int id);
    List<PedidoDTO> obtenerTodosLosPedidos();
    PedidoDTO actualizarPedido(PedidoDTO pedidoDTO);
    void eliminarPedido(int id);
    List<PedidoDetalleDTO> obtenerDetallesPorIdPedido(int id);
}
