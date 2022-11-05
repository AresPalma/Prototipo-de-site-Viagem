package br.com.agencia.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.exception.ClienteNotFoundException;
import br.com.agencia.model.Cliente;
import br.com.agencia.repository.UsuarioRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Cliente saveCliente(Cliente cliente) {
       return repo.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
       return repo.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
       Optional<Cliente> opt = repo.findById(id);
       if(opt.isPresent()) {
           return opt.get();
       } else {
           throw new ClienteNotFoundException("Cliente com Id : "+id+" não encontrado.");
       }
    }

    @Override
    public void deleteClienteById(Long id) {
       repo.delete(getClienteById(id)); 
    }

    @Override
    public void updateCliente(Cliente Cliente) {
       repo.save(Cliente);
    }
}