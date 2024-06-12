package pe.com.cibertec.ProyectoPolleriaApp.model.bd;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpedidoDetalle;

    @ManyToOne
    @JoinColumn(name = "idpedido", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    @Column(name = "idproducto")
    private int idproducto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private double precio;

    @Column(name = "subtotal")
    private double subtotal;
}
