package pe.com.cibertec.ProyectoPolleriaApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.service.IPedidoDetalleService;
import pe.com.cibertec.ProyectoPolleriaApp.service.IPedidoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IPedidoDetalleService pedidoDetalleService;

    @GetMapping("/listar")
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos"; // Nombre de la vista HTML
    }

    @GetMapping("/{id}/detalles")
    public String mostrarEditarDetalles(@PathVariable int id, Model model) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id);
        if (pedido != null) {
            List<PedidoDetalle> detalles = pedido.getDetalles();
            model.addAttribute("pedido", pedido);
            model.addAttribute("detalles", detalles != null ? detalles : new ArrayList<>());
            return "editar-detalles";
        } else {
            return "error"; // Página de error si no se encuentra el pedido
        }
    }

    @PostMapping("/{id}/detalles/update")
    public String actualizarDetalles(@PathVariable int id, @ModelAttribute Pedido pedido, Model model) {
        Pedido pedidoExistente = pedidoService.obtenerPedidoPorId(id);
        if (pedidoExistente != null) {
            List<PedidoDetalle> detallesActualizados = pedido.getDetalles();
            if (detallesActualizados != null) {
                pedidoExistente.getDetalles().clear();
                for (PedidoDetalle detalle : detallesActualizados) {
                    detalle.setPedido(pedidoExistente);
                    pedidoExistente.getDetalles().add(detalle);
                }
                pedidoService.actualizarPedido(pedidoExistente);
            }
        }
        return "redirect:/pedidos/listar"; // Redirige a la lista de pedidos
    }
}
