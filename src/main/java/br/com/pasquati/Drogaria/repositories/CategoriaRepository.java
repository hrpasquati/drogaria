package br.com.pasquati.Drogaria.repositories;

import br.com.pasquati.Drogaria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Essa classe que vai ser capaz de acessar o banco de dados para fazer as consultas para acessar os dados da tabela categoria
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {



}

