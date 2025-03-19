package com.cormus.architecture.app.domain.adapters.gateway;

import com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource;
import com.cormus.architecture.app.domain.entity.Pedido;

import java.util.List;

public class PedidoGateway {

    private final PedidoDataSource pedidoDataSource;

    public PedidoGateway(PedidoDataSource pedidoDataSource){
        this.pedidoDataSource  = pedidoDataSource;
    }

    public List<Pedido> listar(){
        return this.pedidoDataSource.listar();
    }

    public Pedido cadastrar(Pedido pedido){
        return this.pedidoDataSource.cadastrar(pedido);
    }

}
