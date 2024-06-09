package pe.com.cibertec.ProyectoPolleriaApp.service;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;

import java.util.List;

public interface IPedidoService {
    Pedido crearPedido(Pedido pedido);
    Pedido obtenerPedidoPorId(int id);
    List<Pedido> obtenerTodosLosPedidos();
    Pedido actualizarPedido(Pedido pedido);
    void eliminarPedido(int id);
}
