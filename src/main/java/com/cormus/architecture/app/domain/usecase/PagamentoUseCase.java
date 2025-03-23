package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PagamentoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.common.interfaces.PagamentoService;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;

public class PagamentoUseCase {

    private final PedidoGateway pedidoGateway;

    private final PagamentoGateway pagamentoGateway;

    public PagamentoUseCase(PedidoGateway pedidoGateway, PagamentoGateway pagamentoGateway){
        this.pedidoGateway = pedidoGateway;
        this.pagamentoGateway = pagamentoGateway;
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

    public String pagamentoQrCodeGerar(Pedido pedido){
        return this.pagamentoGateway.pagamentoQrCodeGerar(pedido);
    }

}
