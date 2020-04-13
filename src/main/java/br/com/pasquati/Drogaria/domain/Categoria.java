package br.com.pasquati.Drogaria.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity // para ser uma tabela no banco de dados
public class Categoria implements Serializable {

    @Id //Na chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //definição a estrategia automatica dos IDs no banco de dados
    private Long id;
    private String name;

    public Categoria() {
    }

    public Categoria(Long id, String name) {    
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
