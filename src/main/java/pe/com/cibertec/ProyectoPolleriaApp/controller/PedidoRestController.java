package pe.com.cibertec.ProyectoPolleriaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDTO;
import pe.com.cibertec.ProyectoPolleriaApp.model.dto.PedidoDetalleDTO;
import pe.com.cibertec.ProyectoPolleriaApp.service.IPedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerTodosLosPedidos() {
        List<PedidoDTO> pedidos = pedidoService.obtenerTodosLosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable int id) {
        PedidoDTO pedido = pedidoService.obtenerPedidoPorId(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO nuevoPedido = pedidoService.crearPedido(pedidoDTO);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> actualizarPedido(@PathVariable int id, @RequestBody PedidoDTO pedidoDTO) {
        pedidoDTO.setIdpedido(id);
        PedidoDTO pedidoActualizado = pedidoService.actualizarPedido(pedidoDTO);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/detalles")
    public ResponseEntity<List<PedidoDetalleDTO>> obtenerDetallesPorIdPedido(@PathVariable int id) {
        List<PedidoDetalleDTO> detalles = pedidoService.obtenerDetallesPorIdPedido(id);
        if (detalles != null) {
            return new ResponseEntity<>(detalles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
