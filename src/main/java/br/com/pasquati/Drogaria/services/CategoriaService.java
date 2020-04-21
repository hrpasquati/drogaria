package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Categoria;
import br.com.pasquati.Drogaria.repositories.CategoriaRepository;
import br.com.pasquati.Drogaria.services.exception.DataIntegrityException;
import br.com.pasquati.Drogaria.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id " + id + " tipo: " + Categoria.class.getName()));
    }//Caso esse id não exista, o metodo vai lancar uma excessão, apartir da classe ObjectNotFundException

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria insert(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel deletar uma categoria que possui produtos");
        }
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(orderBy), direction);
        return categoriaRepository.findAll(pageRequest);
    }

}
