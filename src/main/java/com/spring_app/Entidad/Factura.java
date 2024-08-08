package com.spring_app.Entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;
    private Double precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
}
