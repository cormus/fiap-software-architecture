package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;

import java.util.List;

public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway){
        this.pedidoGateway = pedidoGateway;
    }

    public List<Pedido> pedidosListar(){
        return this.pedidoGateway.listar();
    }

    public Pedido statusPedidoAtualizar(PedidoCadastradoDTO pedidoCadastradoDTO){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoCadastradoDTO.getId());
        pedido.setStatus(pedidoCadastradoDTO.getStatus());
        return this.pedidoGateway.statusPedidoAtualizar(pedido);
    }
}
