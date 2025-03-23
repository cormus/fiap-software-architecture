package com.cormus.architecture.app.domain.common.interfaces;

import com.cormus.architecture.app.domain.entity.Pedido;

public interface PagamentoService {
    public String pagamentoQrCodeGerar(Pedido pedido);
}
