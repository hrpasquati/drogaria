package br.com.pasquati.Drogaria.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco endercoDeEntrega;
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long id, Date instante, Pagamento pagamento, Cliente cliente, Endereco endercoDeEntrega) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.endercoDeEntrega = endercoDeEntrega;
    }

    public double getValorTotal() {
        double soma = 0;
        for (ItemPedido itemPedido : itens) {
            soma = soma + itemPedido.getSubTotal();
        }
        return soma;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndercoDeEntrega() {
        return endercoDeEntrega;
    }

    public void setEndercoDeEntrega(Endereco endercoDeEntrega) {
        this.endercoDeEntrega = endercoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final StringBuilder sb = new StringBuilder();
        sb.append("Pedido número: ");
        sb.append(getId());
        sb.append(" , Instante: ").append(simpleDateFormat.format(getInstante()));
        sb.append(" , Cliente: ");
        sb.append(getCliente().getNome());
        sb.append(" , Situação do pagamento: ");
        sb.append(getPagamento().getEstadoPagamento().getDescrição());
        sb.append("\nDetalhes\n");
        for (ItemPedido itemPedido : getItens()){
            sb.append(itemPedido.toString());
        }
        sb.append("Valor total :");
        sb.append(numberFormat.format(getValorTotal()));
        return sb.toString();
    }
}
