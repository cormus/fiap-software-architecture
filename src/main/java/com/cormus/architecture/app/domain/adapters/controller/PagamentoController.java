package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.PagamentoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoPresenter;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoStatusPresenter;
import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.interfaces.PagamentoService;
import com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.domain.usecase.PagamentoUseCase;
import org.springframework.security.core.parameters.P;

public class PagamentoController {

    private final PedidoDataSource pedidoDataSource;
    private final PagamentoService pagamentoService;

    public PagamentoController(PedidoDataSource pedidoDataSource, PagamentoService pagamentoService){
        this.pedidoDataSource = pedidoDataSource;
        this.pagamentoService = pagamentoService;
    }

    public PagamentoStatusDTO pagamentoStatusConsultar(Long idPedido){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        PagamentoGateway pagamentoGateway = new PagamentoGateway(this.pagamentoService);
        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase(pedidoGateway, pagamentoGateway);
        Pedido pedido = pagamentoUseCase.pagamentoStatusConsultar(idPedido);
        return PedidoStatusPresenter.bind(pedido);
    }

    public PagamentoStatusDTO statusPagamentoAtualizar(PagamentoStatusDTO pagamentoStatusDTO){
        Pedido pedido = new Pedido();
        pedido.setId(pagamentoStatusDTO.getIdPedido());
        pedido.setStatus_pagamento(pagamentoStatusDTO.getStatus());

        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        PagamentoGateway pagamentoGateway = new PagamentoGateway(this.pagamentoService);
        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase(pedidoGateway, pagamentoGateway);
        Pedido pedidoAtualizado = pagamentoUseCase.statusPagamentoAtualizar(pedido);
        return PedidoStatusPresenter.bind(pedidoAtualizado);
    }

}
