package com.cormus.architecture.presenters;
import com.cormus.architecture.app.domain.adapters.presenters.PedidoStatusPresenter;
import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoStatusPresenterTest {

    @Test
    void deveRetornarPagamentoStatusDTOComStatus() {
        PagamentoStatusDTO dto = PedidoStatusPresenter.bind(PagamentoStatusEnum.PAID);

        assertNotNull(dto);
        assertEquals(PagamentoStatusEnum.PAID, dto.getStatus());
        assertNull(dto.getIdPedido());
    }

    @Test
    void deveRetornarPagamentoStatusDTOComPedido() {
        Pedido pedido = new Pedido();
        pedido.setId(123L);
        pedido.setStatus_pagamento(PagamentoStatusEnum.PAID);

        PagamentoStatusDTO dto = PedidoStatusPresenter.bind(pedido);

        assertNotNull(dto);
        assertEquals(123L, dto.getIdPedido());
        assertEquals(PagamentoStatusEnum.PAID, dto.getStatus());
    }
}