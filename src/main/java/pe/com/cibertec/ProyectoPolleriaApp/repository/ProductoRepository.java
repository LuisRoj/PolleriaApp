package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
