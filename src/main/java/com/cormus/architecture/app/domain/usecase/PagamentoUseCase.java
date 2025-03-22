package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;

public class PagamentoUseCase {

    private final PedidoGateway pedidoGateway;

    public PagamentoUseCase(PedidoGateway pedidoGateway){
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido pagamentoStatusConsultar(Long idPedido){
        Pedido pedido = this.pedidoGateway.pedidoPorId(idPedido);
        if(pedido == null){
            throw new IllegalArgumentException("Pedido não existe");
        }

        return pedido;
    }

    public Pedido statusPagamentoAtualizar(Pedido pedido){

        Pedido pedidoEncontrado = this.pagamentoStatusConsultar(pedido.getId());

        if(pedidoEncontrado.getStatus_pagamento() != PagamentoStatusEnum.WAITING){
            throw new IllegalArgumentException("Status do pagamento não pode ser atualizado");
        }

        return this.pedidoGateway.statusPagamentoAtualizar(pedido);
    }

}
