package br.com.pasquati.Drogaria.resources;

import br.com.pasquati.Drogaria.domain.Cliente;
import br.com.pasquati.Drogaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    public ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente clienteById = clienteService.findById(id);
        return ResponseEntity.ok(clienteById);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientesFindAll = clienteService.findAll();
        return ResponseEntity.ok(clientesFindAll);
    }
}
