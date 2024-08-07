package com.spring_app.Controlador;

import com.spring_app.Entidad.Cliente;
import com.spring_app.Entidad.Producto;
import com.spring_app.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/productos/{id_cliente}")
    public  String mostrarProductosByClienteId(@PathVariable Long id_cliente, Model model){
        List<Producto> productos = clienteServicio.buscarProductosByClienteId(id_cliente);
                model.addAttribute("productos", productos);
                return "/Cliente/vistaCliente";
    }

    //LEER
    @GetMapping("/clientes")
    public String mostrarClientes(Model model){
        List<Cliente> clientes = clienteServicio.listarCliente();
        model.addAttribute("clientes", clientes);
        return "/Cliente/vistaCliente";
    }
    //CREAR
    @GetMapping("/clienteForm")
    public String formularioCliente(Model model){
        model.addAttribute("clientes", new Cliente());
        return "/Cliente/clienteForm";
    }
    @PostMapping("/guardar")
    public String crearCliente(Cliente cliente){
        clienteServicio.guadarCliente(cliente);
        return "redirect:/vistaCliente";
    }
}
