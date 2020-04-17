package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Produto;
import br.com.pasquati.Drogaria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }



}
