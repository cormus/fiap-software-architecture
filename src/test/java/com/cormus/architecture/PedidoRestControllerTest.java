package com.cormus.architecture;

import com.cormus.architecture.app.controller.PedidoRestController;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.common.dto.PedidoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoRestControllerTest {

    @Mock
    PedidoDataSource pedidoDataSource;

    @InjectMocks
    private PedidoGateway pedidoGateway;

    @InjectMocks
    private PedidoRestController pedidoRestController;

    @BeforeEach
    void setup() {

        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();

        pedido1.setId(1L);
        pedido1.setStatus(PedidoStatusEnum.PRONTO);
        pedido1.setStatus_pagamento(PagamentoStatusEnum.PAID);
        pedido1.setIdUsuario(1L);

        pedido2.setId(2L);
        pedido2.setStatus(PedidoStatusEnum.FINALIZADO);
        pedido2.setStatus_pagamento(PagamentoStatusEnum.PAID);
        pedido2.setIdUsuario(2L);


        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

        PedidoEntity pedidoEntity1 = new PedidoEntity();
        PedidoEntity pedidoEntity2 = new PedidoEntity();

        List<PedidoEntity> pedidosEntity = Arrays.asList(pedidoEntity1, pedidoEntity2);

        when(pedidoDataSource.listar()).thenReturn(pedidos);
        when(pedidoDataSource.pedidoPorId(anyLong())).thenReturn(pedido1);
    }

    @Test
    void testListarPedidos() {

        ResponseEntity<List<PedidoCadastradoDTO>> result = pedidoRestController.listar();

        assertEquals(1, result.getBody().size());
    }

    @Test
    void testBuscarPedidoPorId() {

        ResponseEntity<PedidoCadastradoDTO> response = pedidoRestController.pedido(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testStatusPedidoAtualizar() {

        PedidoAtualizarStatusRequest request = mock(PedidoAtualizarStatusRequest.class);
        when(request.idPedido()).thenReturn(1L);
        when(request.status()).thenReturn(PedidoStatusEnum.PRONTO);

        ResponseEntity<Pedido> response = pedidoRestController.statusPedidoAtualizar(request);

        assertEquals(200, response.getStatusCodeValue());
    }

}


