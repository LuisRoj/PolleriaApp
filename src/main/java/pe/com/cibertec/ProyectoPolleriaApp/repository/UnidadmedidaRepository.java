package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Unidadmedida;

@Repository
public interface UnidadmedidaRepository extends JpaRepository<Unidadmedida, Integer>{

	
	
}
