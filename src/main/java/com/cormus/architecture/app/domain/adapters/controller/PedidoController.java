package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoPresenter;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource;
import com.cormus.architecture.app.domain.usecase.PedidoUseCase;

import java.util.List;

public class PedidoController {

    private final PedidoDataSource pedidoDataSource;

    public PedidoController(PedidoDataSource pedidoDataSource){
        this.pedidoDataSource = pedidoDataSource;
    }

    public List<PedidoCadastradoDTO> listar(){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        return PedidoPresenter.listBind(pedidoUseCase.pedidosListar());
    }

    public PedidoCadastradoDTO pedidoPorId(Long idPedido){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        return PedidoPresenter.bind(pedidoUseCase.pedidoPorId(idPedido));
    }

    public PedidoCadastradoDTO statusPedidoAtualizar(PedidoCadastradoDTO pedidoCadastradoDTO){
        PedidoGateway pedidoGateway = new PedidoGateway(this.pedidoDataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        return PedidoPresenter.bind(pedidoUseCase.statusPedidoAtualizar(pedidoCadastradoDTO));
    }

}
