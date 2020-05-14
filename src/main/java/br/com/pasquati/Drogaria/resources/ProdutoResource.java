package br.com.pasquati.Drogaria.resources;

import br.com.pasquati.Drogaria.domain.Produto;
import br.com.pasquati.Drogaria.dto.ProdutoDTO;
import br.com.pasquati.Drogaria.resources.utils.URL;
import br.com.pasquati.Drogaria.services.ProdutoService;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findByProduto(@RequestParam(value = "nome", defaultValue = "") String nome,
                                                          @RequestParam(value = "categoria", defaultValue = "") String categoria,
                                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linsPerPage,
                                                          @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                          @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
       String nomeDecod = URL.decodeParam(nome);
        List<Long> ids = URL.decodeIntList(categoria);
        Page<Produto> list = produtoService.searchProduto(nomeDecod,ids,page, linsPerPage, orderBy, direction );
        Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }


}
