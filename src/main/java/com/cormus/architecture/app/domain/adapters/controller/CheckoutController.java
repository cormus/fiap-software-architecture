package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.PagamentoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoPresenter;
import com.cormus.architecture.app.domain.common.dto.CheckoutDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.common.interfaces.PagamentoService;
import com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource;
import com.cormus.architecture.app.domain.common.interfaces.datasource.UsuarioDataSource;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.usecase.CheckoutUseCase;
import com.cormus.architecture.app.domain.usecase.PagamentoUseCase;

public class CheckoutController {

    private final PedidoDataSource pedidoDataSource;

    private final UsuarioDataSource usuarioDataSource;

    private final PagamentoService pagamentoService;

    public CheckoutController(PedidoDataSource pedidoDataSource, UsuarioDataSource usuarioDataSource, PagamentoService pagamentoService){
        this.pedidoDataSource = pedidoDataSource;
        this.usuarioDataSource = usuarioDataSource;
        this.pagamentoService = pagamentoService;
    }

    public CheckoutDTO cadastrar(PedidoCadastroDTO pedidoCadastroDTO){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        UsuarioGateway usuarioGateway = new UsuarioGateway(this.usuarioDataSource);
        CheckoutUseCase checkoutUseCase = new CheckoutUseCase(pedidoGateway, usuarioGateway);

        Pedido pedido = checkoutUseCase.cadastrarPedido(pedidoCadastroDTO);

        PagamentoGateway pagamentoGateway = new PagamentoGateway(this.pagamentoService);
        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase(pedidoGateway, pagamentoGateway);
        String qrCodeUrl = pagamentoUseCase.pagamentoQrCodeGerar(pedido);

        return PedidoPresenter.bind(pedido, qrCodeUrl);
    }
}
