package com.cormus.architecture.app.infra.common.converter;

import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoItemEntity;

import java.util.List;

public class PedidoItemConverter {

    public static PedidoItem pedidoItemEntityToPedido(PedidoItemEntity pedidoItemEntity){
        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setId(pedidoItemEntity.getId());
        pedidoItem.setQuantidade(pedidoItemEntity.getQuantidade());
        pedidoItem.setProduto(ProdutoConverter.produtoEntityToProduto(pedidoItemEntity.getProduto()));
        return pedidoItem;
    }

    public static List<PedidoItem> pedidosItemEntityToPedidos(List<PedidoItemEntity> pedidosItensEntity){
        return pedidosItensEntity.stream().map(pedidoItemEntity -> PedidoItemConverter.pedidoItemEntityToPedido(pedidoItemEntity)).toList();
    }

}
