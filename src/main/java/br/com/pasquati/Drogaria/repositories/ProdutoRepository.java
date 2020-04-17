package br.com.pasquati.Drogaria.repositories;

import br.com.pasquati.Drogaria.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
