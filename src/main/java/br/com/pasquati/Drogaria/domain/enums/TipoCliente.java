package br.com.pasquati.Drogaria.domain.enums;

public enum TipoCliente {
    PESSOAFISICA(1, "pessoa juridica"),
    PESSOAJURIDICA(2, "pessoa fisica");

    private Integer cododigoTipoCliente;
    private String descricaoDoTipoCliente;

    TipoCliente(int cododigoTipoCliente, String descricaoDoTipoCliente) {
        this.cododigoTipoCliente = cododigoTipoCliente;
        this.descricaoDoTipoCliente = descricaoDoTipoCliente;
    }

    public int getCododigoTipoCliente() {
        return cododigoTipoCliente;
    }

    public String getDescricaoDoTipoCliente() {
        return descricaoDoTipoCliente;
    }

    public static TipoCliente toEnum(Integer cododigoTipoCliente){
        if (cododigoTipoCliente == null){
            return null;
        }
        for (TipoCliente x : TipoCliente.values()) {
            if (cododigoTipoCliente.equals(x.getCododigoTipoCliente())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido " + cododigoTipoCliente);
    }
}
