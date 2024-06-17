package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="categorias")
@Data
public class Categoria {

	@Id
	private int idcategoria;
	
	@Column(name = "nombre_categoria")
	private String nombrecategoria;
	
	@Column(name = "estado_categoria")
	private int estadocategoria;
	
}
