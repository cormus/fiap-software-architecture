package com.cormus.architecture.app.infra.service;

import com.cormus.architecture.app.domain.entity.Pedido;

public class PagamentoService implements com.cormus.architecture.app.domain.common.interfaces.PagamentoService {


    @Override
    public String pagamentoQrCodeGerar(Pedido pedido) {
        return "https://mercadopago.com.br/qrcode.png";
    }

}
