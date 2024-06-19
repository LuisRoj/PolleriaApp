package pe.com.cibertec.ProyectoPolleriaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	
	
}
