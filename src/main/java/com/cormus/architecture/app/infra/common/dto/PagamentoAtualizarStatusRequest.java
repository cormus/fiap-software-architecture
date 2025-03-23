package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import jakarta.validation.constraints.NotNull;

public record PagamentoAtualizarStatusRequest(
        @NotNull
        Long idPedido,

        @NotNull
        PagamentoStatusEnum status
) {
}
