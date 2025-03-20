package com.cormus.architecture.app.domain.adapters.presenters;

import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;

public class PedidoStatusPresenter {

    public static PagamentoStatusDTO bind(PagamentoStatusEnum status){
        PagamentoStatusDTO pagamentoStatusDTO = new PagamentoStatusDTO();
        pagamentoStatusDTO.setStatus(status);
        return pagamentoStatusDTO;
    }

    public static PagamentoStatusDTO bind(Pedido pedido){
        PagamentoStatusDTO pagamentoStatusDTO = new PagamentoStatusDTO();
        pagamentoStatusDTO.setIdPedido(pedido.getId());
        pagamentoStatusDTO.setStatus(pedido.getStatus_pagamento());
        return pagamentoStatusDTO;
    }

}
