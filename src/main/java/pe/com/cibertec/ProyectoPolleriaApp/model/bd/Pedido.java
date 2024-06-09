package pe.com.cibertec.ProyectoPolleriaApp.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpedido;

    @Column(name = "idusuario")
    private int idusuario;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    @Column(name = "estado_pedido")
    private byte estadoPedido;

    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference // Anotación para el lado padre
    private List<PedidoDetalle> detalles;

    @Override
    public String toString() {
        return "Pedido{" +
                "idpedido=" + idpedido +
                ", idusuario=" + idusuario +
                ", fechaPedido=" + fechaPedido +
                ", estadoPedido=" + estadoPedido +
                ", total=" + total +
                '}';
    }

}
