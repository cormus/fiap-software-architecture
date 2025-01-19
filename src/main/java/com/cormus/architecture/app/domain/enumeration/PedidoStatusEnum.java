package com.cormus.architecture.app.domain.enumeration;

public enum PedidoStatusEnum {
    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em preparação"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    private final String descricao;

    PedidoStatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
