package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="unidad_medida")
@Data
public class Unidadmedida {
	
	@Id
	@Column(name = "idunidad_medida")
	private int idunidadmedida;
	
	@Column(name = "nombre_unidad")
	private String nombreunidad;
	
	@Column(name = "estado_unidad")
	private int estadounidad;
	

}