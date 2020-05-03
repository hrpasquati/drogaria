package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Cidade;
import br.com.pasquati.Drogaria.domain.Cliente;
import br.com.pasquati.Drogaria.domain.Endereco;
import br.com.pasquati.Drogaria.domain.enums.TipoCliente;
import br.com.pasquati.Drogaria.dto.ClienteDTO;
import br.com.pasquati.Drogaria.dto.ClinteNewDTO;
import br.com.pasquati.Drogaria.repositories.CidadeRepository;
import br.com.pasquati.Drogaria.repositories.ClienteRepository;
import br.com.pasquati.Drogaria.repositories.EnderecoRepository;
import br.com.pasquati.Drogaria.services.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //Faz a injeção de dependencia
    public ClienteRepository clienteRepository;

    @Autowired
    public CidadeRepository cidadeRepository;

    @Autowired
    public EnderecoRepository enderecoRepository;

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElse(null);
    } //Metodo capaz de buscar um cliente no banco de dados passando como paramento o ID.

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }//Metodo que busca todos os clientes do banco de dados

    public Cliente insert(Cliente cliente) {
        cliente.setId(null);
        cliente = clienteRepository.save(cliente);
        enderecoRepository.saveAll(cliente.getEnderecos());
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        Cliente newCliente = findById(cliente.getId());
        updateData(newCliente, cliente);
        return clienteRepository.save(newCliente);
    }


    public void delete(Long id) {
        findById(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel deletar");
        }
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(orderBy), direction);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO){
        return new Cliente(clienteDTO.getId(), clienteDTO.getName(), clienteDTO.getEmail(), null, null);
    }

    public Cliente fromDTO(ClinteNewDTO clinteNewDTO){
        Cliente cli = new Cliente(null, clinteNewDTO.getNome(), clinteNewDTO.getEmail(), clinteNewDTO.getCpfOuCnpj(), TipoCliente.toEnum(clinteNewDTO.getTipo()));
        Cidade cidade = new Cidade(clinteNewDTO.getCidadeId(), null, null);
        Endereco endereco = new Endereco(null, clinteNewDTO.getLogradouro(), clinteNewDTO.getNumero(), clinteNewDTO.getComplemento(), clinteNewDTO.getBairro(), clinteNewDTO.getCep(), cli, cidade);
        cli.getEnderecos().add(endereco);
        cli.getTelefone().add(clinteNewDTO.getTelefone1());
        if (clinteNewDTO.getTelefone2() != null){
            cli.getTelefone().add(clinteNewDTO.getTelefone2());
        }
        if (clinteNewDTO.getTelefone3() != null ){
            cli.getTelefone().add(clinteNewDTO.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newCliente, Cliente cliente) {
        newCliente.setNome(cliente.getNome());
        newCliente.setEmail(cliente.getEmail());
    }

}
