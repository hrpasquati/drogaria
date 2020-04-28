package br.com.pasquati.Drogaria.dto;

import br.com.pasquati.Drogaria.domain.Categoria;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private Long id;
    @NotEmpty(message = "Preenchimento obrigatorio")
    private String name;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.name = categoria.getName();
    }//Resposavel por criar um DTO apartir de categoria

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
}
