package com.spring_app.Entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;

    @ManyToMany
    @JoinTable(name="cliente_producto",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))

    private List<Producto> productos;

    public List<Producto> mostrarProductos(){
        return productos;
    }
}
