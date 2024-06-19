package pe.com.cibertec.ProyectoPolleriaApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Producto;
import pe.com.cibertec.ProyectoPolleriaApp.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoRepository repoProd;
	
	@Override
	public List<Producto> listarTodos() {
		return repoProd.findAll();
	}

	@Override
	public Producto registrar(Producto producto) {
		return repoProd.save(producto);
	}

}
