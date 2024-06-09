package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
