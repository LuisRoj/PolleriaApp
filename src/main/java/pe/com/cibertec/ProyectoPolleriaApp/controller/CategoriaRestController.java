package pe.com.cibertec.ProyectoPolleriaApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Categoria;
import pe.com.cibertec.ProyectoPolleriaApp.repository.CategoriaRepository;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaRepository repoCat;
	
	@GetMapping
	public List<Categoria> listarCategoria(){
		
		return repoCat.findAll();
	}

}
