package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;

public record PedidoAtualizarStatusRequest(
        Long idPedido,
        PedidoStatusEnum status
) {
}
