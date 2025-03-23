package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway){
        this.pedidoGateway = pedidoGateway;
    }

    public List<Pedido> pedidosListar(){
        List<Pedido> pedidos = this.pedidoGateway.listar();

        List<Pedido> pedidosOrdenados = pedidos.stream()
                .filter(p -> p.getStatus() != PedidoStatusEnum.FINALIZADO && p.getStatus() != PedidoStatusEnum.CANCELADO)
                .sorted(Comparator.comparing(
                        Pedido::getStatus,
                        Comparator.comparingInt(s -> {
                            if (s == PedidoStatusEnum.PRONTO) return 1;
                            if (s == PedidoStatusEnum.EM_PREPARACAO) return 2;
                            return 3; // RECEBIDO
                        })
                ).thenComparing(Pedido::getPedidoData))
                .collect(Collectors.toList());

        return pedidosOrdenados;
    }

    public Pedido statusPedidoAtualizar(PedidoCadastradoDTO pedidoCadastradoDTO){
        Pedido pedido = this.pedidoGateway.pedidoPorId(pedidoCadastradoDTO.getId());

        if(pedido.getStatus() == PedidoStatusEnum.CANCELADO){
            throw new IllegalArgumentException("Não foi possível atualizar o status: Pedido cancelado.");
        }

        if(pedido.getStatus_pagamento() != PagamentoStatusEnum.AUTHORIZED && pedido.getStatus_pagamento() != PagamentoStatusEnum.PAID){
            throw new IllegalArgumentException("Aguardando confirmação de pagamento: Só é possível atualizar o status dos pedidos com pagamento confirmado.");
        }

        pedido.setStatus(pedidoCadastradoDTO.getStatus());
        return this.pedidoGateway.statusPedidoAtualizar(pedido);
    }
}
