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
import java.util.Optional;

@Controller
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteServicio;

//    @GetMapping("/productos/{id_cliente}")
//    public  String mostrarProductosByClienteId(@PathVariable Long id_cliente, Model model){
//        List<Producto> productos = clienteServicio.buscarProductosByClienteId(id_cliente);
//                model.addAttribute("productos", productos);
//                return "/Cliente/vistaCliente";
//    }

    //LEER
    @GetMapping("/cliente")
    public String mostrarClientes(Model model){
        List<Cliente> clientes = clienteServicio.listarClientes();
        model.addAttribute("cliente", clientes);
        return "/Cliente/listarCliente";
    }

    //CREAR
    @GetMapping("/formularioCliente")
    public String formularioCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "/Cliente/formularioCliente";
    }

    @PostMapping("/guardarCliente")
    public String crearCliente(Cliente cliente){
        clienteServicio.guadarClientes(cliente);
        return "redirect:/cliente";
    }

    //ACTUALIZAR
    @GetMapping("/editarCliente/{id}")
    public String actualizarCliente(@PathVariable Long id, Model model){
        Optional<Cliente> cliente = clienteServicio.buscarCliente(id);
        model.addAttribute("cliente", cliente);
        return "/Cliente/formularioCliente";
    }

    //ELIMINAR
    @GetMapping("/eliminarCliente/{id}")
    public String borrarCliente(@PathVariable Long id){
        clienteServicio.eliminarClientes(id);
        return "redirect:/cliente";
    }

}
