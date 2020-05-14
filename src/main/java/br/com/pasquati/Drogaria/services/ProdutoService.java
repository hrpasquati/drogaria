package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Categoria;
import br.com.pasquati.Drogaria.domain.Produto;
import br.com.pasquati.Drogaria.repositories.CategoriaRepository;
import br.com.pasquati.Drogaria.repositories.ProdutoRepository;
import br.com.pasquati.Drogaria.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Page<Produto> searchProduto (String nome, List<Long> ids, Integer pages, Integer linsPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(pages, linsPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.search(nome, categorias, pageRequest);
    }



}
