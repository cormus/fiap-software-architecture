package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoItemCadastroDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;

import java.time.LocalDateTime;

public class CheckoutUseCase {

    private final PedidoGateway pedidoGateway;


    public CheckoutUseCase(PedidoGateway pedidoGateway){
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido cadastrarPedido(PedidoCadastroDTO pedidoCadastroDTO){

        Pedido pedido = new Pedido();
        pedido.setIdUsuario(pedidoCadastroDTO.getIdUsuario());
        pedido.setStatus(PedidoStatusEnum.RECEBIDO);
        pedido.setStatus_pagamento(PagamentoStatusEnum.WAITING);
        pedido.setPedidoData(LocalDateTime.now());

        for (PedidoItemCadastroDTO item : pedidoCadastroDTO.getItens()) {
            Produto produto = new Produto(item.getProduto().getId());

            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setQuantidade(item.getQuantidade());
            pedidoItem.setValor(item.getValor());
            pedidoItem.setProduto(produto);

            pedido.addItem(pedidoItem);
        }

        this.pedidoGateway.cadastrar(pedido);

        return pedido;
    }

}
