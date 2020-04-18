package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Cliente;
import br.com.pasquati.Drogaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElse(null);
    } //Metodo capaz de buscar um cliente no banco de dados passando como paramento o ID.

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }//Metodo que busca todos os clientes do banco de dados
}
