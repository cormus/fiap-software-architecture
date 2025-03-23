package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoPresenter;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource;
import com.cormus.architecture.app.domain.usecase.CheckoutUseCase;

public class CheckoutController {

    private final PedidoDataSource pedidoDataSource;

    public CheckoutController(PedidoDataSource pedidoDataSource){
        this.pedidoDataSource = pedidoDataSource;
    }

    public PedidoCadastradoDTO cadastrar(PedidoCadastroDTO pedidoCadastroDTO){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        CheckoutUseCase checkoutUseCase = new CheckoutUseCase(pedidoGateway);
        return PedidoPresenter.bind(checkoutUseCase.cadastrarPedido(pedidoCadastroDTO));
    }
}
