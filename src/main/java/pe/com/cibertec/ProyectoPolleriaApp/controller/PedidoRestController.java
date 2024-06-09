package pe.com.cibertec.ProyectoPolleriaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.service.IPedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable int id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        pedido.setIdpedido(id);
        return pedidoService.actualizarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id) {
        pedidoService.eliminarPedido(id);
    }

    @GetMapping("/{id}/detalles")
    public List<PedidoDetalle> obtenerDetallesPorIdPedido(@PathVariable int id) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id);
        if (pedido != null) {
            return pedido.getDetalles();
        } else {
            throw new PedidoNotFoundException("Pedido no encontrado con ID: " + id);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class PedidoNotFoundException extends RuntimeException {
        public PedidoNotFoundException(String mensaje) {
            super(mensaje);
        }
    }


}
