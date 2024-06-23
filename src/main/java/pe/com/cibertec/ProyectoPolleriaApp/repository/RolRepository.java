package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
