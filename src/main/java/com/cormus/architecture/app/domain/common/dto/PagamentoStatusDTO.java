package com.cormus.architecture.app.domain.common.dto;

import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoStatusDTO {
    private Long idPedido;
    private PagamentoStatusEnum status;
}
