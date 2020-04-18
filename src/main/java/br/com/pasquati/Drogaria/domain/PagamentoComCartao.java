package br.com.pasquati.Drogaria.domain;

import br.com.pasquati.Drogaria.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {

    private Integer numerosDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Long id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numerosDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numerosDeParcelas = numerosDeParcelas;
    }

    public Integer getNumerosDeParcelas() {
        return numerosDeParcelas;
    }

    public void setNumerosDeParcelas(Integer numerosDeParcelas) {
        this.numerosDeParcelas = numerosDeParcelas;
    }
}
