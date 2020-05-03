package br.com.pasquati.Drogaria.resources;

import br.com.pasquati.Drogaria.domain.Cliente;
import br.com.pasquati.Drogaria.dto.ClienteDTO;
import br.com.pasquati.Drogaria.dto.ClinteNewDTO;
import br.com.pasquati.Drogaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    public ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> lista = clienteService.findAll();
        List<ClienteDTO> clienteDTOList = lista.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok(clienteDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(value = "/pages")
    public ResponseEntity<Page> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "linePerPage", defaultValue = "24") Integer linesPerPage,
                                         @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                         @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        Page<Cliente> clientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> clienteDTOS = clientes.map(x -> new ClienteDTO(x));
        return ResponseEntity.ok().body(clienteDTOS);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente = clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> insert (@Valid @RequestBody ClinteNewDTO clinteNewDTO){
        Cliente cliente = clienteService.fromDTO(clinteNewDTO);
        cliente = clienteService.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }





}
