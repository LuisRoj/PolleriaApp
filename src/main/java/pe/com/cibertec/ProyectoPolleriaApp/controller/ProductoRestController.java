package pe.com.cibertec.ProyectoPolleriaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Producto;
import pe.com.cibertec.ProyectoPolleriaApp.repository.ProductoRepository;
import pe.com.cibertec.ProyectoPolleriaApp.service.IProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	
	@Autowired
	private IProductoService service;
	
	@Autowired
	private ProductoRepository repoProd;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductos() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Producto> registrarProductos(
			@RequestBody Producto producto) {
		Producto nuevo = service.registrar(producto);
		
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizarProductos(@PathVariable int id,
			@RequestBody Producto productoActualizado){
		
		Producto producto = repoProd.findById(id).get();
		producto.setNombre(productoActualizado.getNombre());
		producto.setIdcategoria(productoActualizado.getIdcategoria());
		producto.setIdunidadmedida(productoActualizado.getIdunidadmedida());
		producto.setIdpresentacion(productoActualizado.getIdpresentacion());
		producto.setPrecio(productoActualizado.getPrecio());
		producto.setEstadoproducto(productoActualizado.getEstadoproducto());
		
		producto = repoProd.save(producto);
		
		return new ResponseEntity<>(producto, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public String eliminarProductos(@PathVariable int id) {
		
		repoProd.deleteById(id);
		
		return "Producto eliminado correctamente";
	}

}
