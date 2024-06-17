package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="presentacion")
@Data
public class Presentacion {
	
	@Id
	private int idpresentacion;
	
	@Column(name = "nombre_presentacion")
	private String nombrepresentacion;
	
	@Column(name = "estado_presentacion")
	private int estadopresentacion;
	

}
