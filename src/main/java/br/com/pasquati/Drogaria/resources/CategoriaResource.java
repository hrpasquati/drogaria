package br.com.pasquati.Drogaria.resources;

import br.com.pasquati.Drogaria.domain.Categoria;
import br.com.pasquati.Drogaria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/categorias" )
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}") // esse value representa o valor do ID que eu entrar na URL
    public ResponseEntity<Categoria> find(@PathVariable Long id){ // para que o Spring da URL venha para o ID da variavel
        Categoria obj = categoriaService.find(id);
        return ResponseEntity.ok(obj);
    }

}
