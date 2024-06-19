package pe.com.cibertec.ProyectoPolleriaApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Unidadmedida;
import pe.com.cibertec.ProyectoPolleriaApp.repository.UnidadmedidaRepository;

@RestController
@RequestMapping("/api/unidadmedidas")
public class UnidadmedidaRestController {

	@Autowired
	private UnidadmedidaRepository repoUni;
	
	@GetMapping
	public List<Unidadmedida> listarUnidadmedida(){
		
		return repoUni.findAll();
	}
	
}
