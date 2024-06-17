package pe.com.cibertec.ProyectoPolleriaApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Presentacion;
import pe.com.cibertec.ProyectoPolleriaApp.repository.PresentacionRepository;


@RestController
@RequestMapping("/api/presentaciones")
public class PresentacionRestController {

	@Autowired
	private PresentacionRepository repoPre;
	
	@GetMapping
	public List<Presentacion> listarPresentacion(){
		
		return repoPre.findAll();
	}
	
}
