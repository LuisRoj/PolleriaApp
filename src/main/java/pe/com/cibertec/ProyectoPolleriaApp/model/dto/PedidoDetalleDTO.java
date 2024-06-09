package pe.com.cibertec.ProyectoPolleriaApp.model.dto;


import lombok.Data;

@Data
public class PedidoDetalleDTO {
    private int idpedidoDetalle;
    private int idproducto;
    private int cantidad;
    private double precio;
    private double subtotal;
}
