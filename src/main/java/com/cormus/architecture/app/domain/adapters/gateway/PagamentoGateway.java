package com.cormus.architecture.app.domain.adapters.gateway;

import com.cormus.architecture.app.domain.common.interfaces.PagamentoService;
import com.cormus.architecture.app.domain.entity.Pedido;

public class PagamentoGateway {

    private final PagamentoService pagamentoService;

    public PagamentoGateway(PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }

    public String pagamentoQrCodeGerar(Pedido pedido){
        return this.pagamentoService.pagamentoQrCodeGerar(pedido);
    }

}
