package pe.com.cibertec.ProyectoPolleriaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
