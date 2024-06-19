package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="productos")
@Data
public class Producto {
	
	@Id
	private int idproducto;
	
	private String nombre;
	
	private int idcategoria;
	
	@Column(name = "idunidad_medida")
	private int idunidadmedida;
	
	private Integer idpresentacion;
	
	private double precio;
	
	@Column(name = "estado_producto")
	private int estadoproducto;

}