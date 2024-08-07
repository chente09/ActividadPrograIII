package com.spring_app.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long stock;

    @OneToOne
    @JoinColumn(name="id_garantia")
    private Garantia garantia;

    @ManyToMany(mappedBy = "productos")
    private List<Cliente> clientes;
}
