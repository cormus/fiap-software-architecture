package com.cormus.architecture.app.infra.common.converter;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;

import java.util.List;

public class PedidoConverter {

    public static Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity ){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setIdUsuario(pedidoEntity.getIdUsuario());
        pedido.setPedidoData(pedidoEntity.getPedidoData());
        pedido.setStatus(pedidoEntity.getStatus());
        pedido.setStatus_pagamento(pedidoEntity.getStatus_pagamento());
        pedido.setItens(PedidoItemConverter.pedidosItemEntityToPedidos(pedidoEntity.getItens()));
        return pedido;
    }

    public static List<Pedido> pedidosEntityToPedidos(List<PedidoEntity> pedidosEntity){
        return pedidosEntity.stream().map(pedidoEntity ->  PedidoConverter.pedidoEntityToPedido(pedidoEntity)).toList();
    }


}
