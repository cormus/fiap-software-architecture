package com.cormus.architecture.app.domain.common.interfaces.datasource;

import com.cormus.architecture.app.domain.entity.Pedido;

import java.util.List;

public interface PedidoDataSource {
    List<Pedido> listar();
    Pedido cadastrar(Pedido pedido);
    Pedido pedidoPorId(Long idPedido);
    Pedido statusPagamentoAtualizar(Pedido pedido);
    Pedido statusPedidoAtualizar(Pedido pedido);
}
