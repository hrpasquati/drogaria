package br.com.pasquati.Drogaria.resources;

import br.com.pasquati.Drogaria.domain.Categoria;
import br.com.pasquati.Drogaria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> lista = categoriaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}") // esse value representa o valor do ID que eu entrar na URL
    public ResponseEntity<Categoria> find(@PathVariable Long id) { // para que o Spring da URL venha para o ID da variavel
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok(obj);
    }


}
