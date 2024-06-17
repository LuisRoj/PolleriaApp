package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Presentacion;

@Repository
public interface PresentacionRepository extends JpaRepository<Presentacion, Integer>{

	
	
}