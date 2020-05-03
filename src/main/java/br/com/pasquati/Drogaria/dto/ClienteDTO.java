package br.com.pasquati.Drogaria.dto;

import br.com.pasquati.Drogaria.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "O nome é obrigatorio")
    private String name;
    @NotEmpty(message = "Campo obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.name = cliente.getNome();
        this.email = cliente.getEmail();
    } //Construtor responsavel por criar um ClienteDTO apartir da classe Cliente

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
