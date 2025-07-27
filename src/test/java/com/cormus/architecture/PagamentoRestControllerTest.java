package com.cormus.architecture;

import com.cormus.architecture.app.controller.PagamentoRestController;
import com.cormus.architecture.app.domain.adapters.gateway.PagamentoGateway;
import com.cormus.architecture.app.domain.common.interfaces.PagamentoService;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.common.dto.PagamentoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PagamentoRestControllerTest {

    @Mock
    PagamentoService dataSource;

    @Mock
    PedidoDataSource pedidoDataSource;

    @InjectMocks
    PagamentoGateway gateway;

    @InjectMocks
    PagamentoRestController controller;

    @BeforeEach
    void setup() {

        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();

        pedido1.setId(1L);
        pedido1.setIdUsuario(1L);
        pedido1.setStatus(PedidoStatusEnum.FINALIZADO);
        pedido1.setStatus_pagamento(PagamentoStatusEnum.WAITING);

        pedido2.setId(2L);
        pedido2.setIdUsuario(2L);
        pedido2.setStatus(PedidoStatusEnum.PRONTO);

        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);


        when(pedidoDataSource.pedidoPorId(anyLong())).thenReturn(pedido1);
        when(pedidoDataSource.statusPagamentoAtualizar(any())).thenReturn(pedido1);
    }

    @Test
    void testStatus() {

        ResponseEntity result = controller.status(1L);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void testWebhook() {

        PagamentoAtualizarStatusRequest request =  mock(PagamentoAtualizarStatusRequest.class);
        when(request.idPedido()).thenReturn(1L);
        when(request.status()).thenReturn(PagamentoStatusEnum.PAID);

        ResponseEntity result = controller.webhook(request);

        assertEquals(200, result.getStatusCodeValue());
    }

}

