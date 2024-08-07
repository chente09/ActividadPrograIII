package com.spring_app.Controlador;

import com.spring_app.Entidad.Producto;
import com.spring_app.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorProducto {

    @Autowired
    ProductoServicio productoServicio;

    //LEER
    @GetMapping("/productos")
    public String mostrarProductos(Model model){
        List<Producto> productos = productoServicio.listarProductos();
        model.addAttribute("productos", productos);
        return "/listarProductos";
    }

    //CREAR
    @GetMapping("/formulario")
    public String formularioProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "/Producto/formulario";
    }

    @PostMapping("/guardar")
    public String crearProducto(Producto producto){
        productoServicio.guadarProducto(producto);
        return "redirect:/productos";
    }


    //ACTUALIZAR
    @GetMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable Long id, Model model){
        Optional<Producto> producto = productoServicio.buscarProducto(id);
        model.addAttribute("producto", producto);
        return "/Producto/formulario";
    }

    //ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String borrarProducto(@PathVariable Long id){
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }
}
