package com.cormus.architecture.app.domain.enumeration;

public enum PagamentoStatusEnum {
    AUTHORIZED("Esse status indica que a transação foi autorizada."),
    PAID("A transação foi concluída com sucesso."),
    IN_ANALYSIS("A transação está em análise pela operadora do Cartão de Crédito."),
    DECLINED("Esse status indica que a transação foi rejeitada."),
    CANCELED("A transação foi cancelada sem ter sido finalizada. Quando o comprador opta por pagar com Boleto Bancário e não finaliza o pagamento, a transação assume este status."),
    WAITING("Aguardando pagamento");

    private final String descricao;

    PagamentoStatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
