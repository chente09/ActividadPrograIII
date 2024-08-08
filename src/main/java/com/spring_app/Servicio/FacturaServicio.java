package com.spring_app.Servicio;

import com.spring_app.Entidad.Factura;
import com.spring_app.Entidad.Producto;
import com.spring_app.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Producto> buscarProductosPorFactura(String numeroFactura){
        return facturaRepositorio.findByNumeroFactura(numeroFactura).stream()
                .map(Factura::getProducto)
                .collect(Collectors.toList());
    }
}
