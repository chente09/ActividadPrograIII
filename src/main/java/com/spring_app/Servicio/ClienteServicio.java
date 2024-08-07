package com.spring_app.Servicio;

import com.spring_app.Entidad.Cliente;
import com.spring_app.Entidad.Producto;
import com.spring_app.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Producto> buscarProductosByClienteId(Long id_cliente){
        return clienteRepositorio.findById(id_cliente)
                .map(Cliente::mostrarProductos)
                .orElse(List.of());
    }

    public List<Cliente> listarClientes(){
        return clienteRepositorio.findAll();
    }
    public Optional<Cliente> buscarCliente(Long id){
        return clienteRepositorio.findById(id);
    }
    public  void  guadarClientes(Cliente cliente){
        clienteRepositorio.save(cliente);
    }
    public void eliminarClientes(Long id){
        clienteRepositorio.deleteById(id);
    }
}
