package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Categoria;
import br.com.pasquati.Drogaria.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Essa classe representa o servico capaz de atender o controlador Rest relacionado com operacoes categoria.
@Service
public class CategoriaService {

    @Autowired //faz com que a dependencia seja automaticamente instanciada pelo Spring
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElse(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }


}
