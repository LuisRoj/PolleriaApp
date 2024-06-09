package pe.com.cibertec.ProyectoPolleriaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.PedidoDetalle;
import pe.com.cibertec.ProyectoPolleriaApp.repository.PedidoDetalleRepository;

@Service
public class PedidoDetalleServiceImpl implements IPedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public void actualizarPedidoDetalle(PedidoDetalle detalle) {
        pedidoDetalleRepository.save(detalle);
    }
}
