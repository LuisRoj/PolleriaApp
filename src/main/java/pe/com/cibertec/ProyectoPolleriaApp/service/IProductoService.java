package pe.com.cibertec.ProyectoPolleriaApp.service;

import java.util.List;
import pe.com.cibertec.ProyectoPolleriaApp.model.bd.Producto;


public interface IProductoService {

	public List<Producto> listarTodos();

	public Producto registrar(Producto producto);

}
