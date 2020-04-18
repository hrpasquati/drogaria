package br.com.pasquati.Drogaria.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer codigo;
    private String descrição;

    EstadoPagamento(int codigo, String descrição) {
        this.codigo = codigo;
        this.descrição = descrição;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrição() {
        return descrição;
    }

    public static EstadoPagamento toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (codigo.equals(x.codigo)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Código invalido: " + codigo);
    }

}

